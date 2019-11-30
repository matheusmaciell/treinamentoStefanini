package treinamento.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtils {

	public static void main(String[] args) {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			System.out.println(encoder.encode("admin"));
	}
}
//$2a$10$pB.xkYa5w5U1b2pQj8ABA.l5DliPv6Sc1R92bXf0H5DQ9K73Hcrqy
//INSERT INTO usuario (nome, email, senha) values ('matheus maciel', 'matheus@stefanini', "matheusestefanini");