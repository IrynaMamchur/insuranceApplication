//package com.example.insuranceapplication.security;
//
//
//import com.example.insuranceapplication.entity.ClientPassword;
//import com.example.insuranceapplication.repository.ClientPasswordRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Configuration
//@EnableWebSecurity
//public class Security {
//    @Autowired
//    private ClientPasswordRepository clientPasswordRepository;
//
//
//
//    protected void securityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(auth->auth
//                .requestMatchers(HttpMethod.GET,"/carBrand/find/coefficient/{carBrandName}").hasRole("USER")
//                .requestMatchers(HttpMethod.GET,"/carEngineCapacity/find/coefficient/{engineCapacity}").hasRole("USER")
//                .requestMatchers(HttpMethod.GET,"/carInsuranceProgram/find/coefficient/{insuranceProgramName}").hasRole("USER")
//                .requestMatchers(HttpMethod.GET,"/carQuantityOfPayments/find/coefficient/{number}").hasRole("USER")
//                .requestMatchers(HttpMethod.GET,"/carYearOfIssue/find/coefficient/{carFirstRegistr}").hasRole("USER")
//                .requestMatchers("/coefficient/update/coefficientForCar").hasRole("USER")
//                .requestMatchers("/client/create").hasRole("USER")
//                .requestMatchers("clientPassword/create").permitAll()
//                .anyRequest().hasRole("ADMIN")
//                )
//                .httpBasic(Customizer.withDefaults())
//                .build();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        List<ClientPassword> clientPasswords = clientPasswordRepository.findAll();
//        List<UserDetails> users = new ArrayList<>();
//
//        for (ClientPassword clientPassword : clientPasswords) {
//            UserDetails userDetails = User
//                    .withUsername(clientPassword.getLogin() + "_" + clientPassword.getId())
//                    .password(clientPassword.getPassword())
//                    .roles("USER")
//                    .build();
//            users.add(userDetails);
//        }
//
//        return new InMemoryUserDetailsManager(users);
//    }
//
//    @Bean
//    public static NoOpPasswordEncoder passwordEncoder() {
//        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
//    }
//}
