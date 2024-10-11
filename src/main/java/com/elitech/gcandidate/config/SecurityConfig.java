package com.elitech.gcandidate.config;

import java.util.List;

import javax.crypto.spec.SecretKeySpec;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.elitech.gcandidate.servicesImp.UserDetailsServiceImp;
import com.nimbusds.jose.jwk.source.ImmutableSecret;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
public class SecurityConfig {

	private UserDetailsServiceImp userDetailsServiceImp;
	
	private String secretKey="cs579gfdfhg675jgjhg342fgdo09533kjvhzee583mxbh574324pnc625k5d9hve";
	
//	@Bean
//	public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
//		PasswordEncoder passwordEncoder=passwordEncoder();
//		return new InMemoryUserDetailsManager(
//				User.withUsername("user1").password(passwordEncoder.encode("1234")).authorities("USER").build(),
//				User.withUsername("admin").password(passwordEncoder.encode("1234")).authorities("ADMIN").build()
//				);
////	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity
				.sessionManagement(sm->sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.csrf(csrf->csrf.disable())
				.cors(Customizer.withDefaults())
				.authorizeHttpRequests(ar->ar.requestMatchers("/auth/login/**").permitAll())
				.authorizeHttpRequests(ar->ar.anyRequest().authenticated())
				//.httpBasic(Customizer.withDefaults())
				.oauth2ResourceServer(oa->oa.jwt(Customizer.withDefaults()))
				
				.build()
				;
		
	}
	@Bean
	public JwtEncoder jwtEncoder() {
		//String secretKey="cs579gfdfhg675jgjhg342fgdo09533kjvhzee583mxbh574324pnc625k5d9hve";
		
		return new NimbusJwtEncoder(new ImmutableSecret<>(secretKey.getBytes()));
	}
	/*
	 * @Bean
	 */
	/*
	 * public JwtDecoder jwtDecoder()
	 
	{
		//String secretKey="cs579gfdfhg675jgjhg342fgdo09533kjvhzee583mxbh574324pnc625k5d9hve";
		SecretKeySpec secretKeySpec=new SecretKeySpec(secretKey.getBytes(),"RSA");
		return NimbusJwtDecoder.withSecretKey(secretKeySpec).macAlgorithm(MacAlgorithm.HS512).build();
	}
	*/
	
	@Bean
	public JwtDecoder jwtDecoder() {
	    SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "HmacSHA512");
	    return NimbusJwtDecoder.withSecretKey(secretKeySpec).macAlgorithm(MacAlgorithm.HS512).build();
	}
	

	
	@Bean
	public AuthenticationManager authenticationManager(UserDetailsServiceImp userDetailsService)
	{
		DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		daoAuthenticationProvider.setUserDetailsService(userDetailsService);
		return new ProviderManager(daoAuthenticationProvider);
	}
	@Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

//        configuration.setAllowedOrigins(List.of("http://localhost:8080"));
//        configuration.setAllowedMethods(List.of("GET","POST"));
//        configuration.setAllowedHeaders(List.of("Authorization","Content-Type"));
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//
//        source.registerCorsConfiguration("/**",configuration);
        configuration.addAllowedOrigin("*");
        configuration.addAllowedMethod("*");
        configuration.addAllowedHeader("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
}
