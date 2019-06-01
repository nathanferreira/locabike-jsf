package br.ufscar.dc.dsw;

import javax.sql.DataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class AppConfig extends WebSecurityConfigurerAdapter {

    private static DataSource dataSource;

    public AppConfig() throws ClassNotFoundException {
        dataSource = AppConfig.getDataSource();
    }

    @Override
    public void configure(AuthenticationManagerBuilder builder)
            throws Exception {

        String userSql = "SELECT email, password, ativo FROM Usuario "
                + " WHERE email = ?";
        String roleSql = "SELECT u.email, p.nome FROM Usuario u, Papel p,"
                + " Usuario_Papel up WHERE up.usuario_email = u.email and"
                + " up.papel_id = p.id and u.email = ?";
        
        builder.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(userSql)
                .authoritiesByUsernameQuery(roleSql)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/faces/admin/**").hasRole("ADMIN")
                .antMatchers("/faces/cliente/**").hasRole("CLIENTE")
                .antMatchers("/faces/locadora/**").hasRole("LOCADORA")
                .antMatchers("/faces/locacao/**").hasRole("CLIENTE")
                .antMatchers("/open/**").permitAll()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));

        http.csrf().disable();
    }

    public static DataSource getDataSource() throws ClassNotFoundException {

        if (dataSource == null) {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String url = "jdbc:derby://localhost:1527/Login";
            String user = "root";
            String password = "root";
            dataSource = new DriverManagerDataSource(url, user, password);
        }

        return dataSource;
    }
}
