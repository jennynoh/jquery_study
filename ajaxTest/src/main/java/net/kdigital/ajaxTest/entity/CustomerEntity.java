package net.kdigital.ajaxTest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.kdigital.ajaxTest.dto.CustomerDTO;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder

@Entity
@Table(name="customer")
public class CustomerEntity {
	@SequenceGenerator(
			name="customer_seq"
			, sequenceName="customer_seq"
			, initialValue=1
			, allocationSize=1)
	@GeneratedValue(generator="customer_seq")
	@Id
	@Column(name="customer_num")
	private Long customerNum;
	private String username;
	private String email;
	
	public static CustomerEntity toEntity(CustomerDTO customerDTO) {
		return CustomerEntity.builder()
				.customerNum(customerDTO.getCustomerNum())
				.username(customerDTO.getUsername())
				.email(customerDTO.getEmail())
				.build();
	}

}
