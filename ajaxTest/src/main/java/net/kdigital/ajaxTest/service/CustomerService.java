package net.kdigital.ajaxTest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.kdigital.ajaxTest.dto.CustomerDTO;
import net.kdigital.ajaxTest.entity.CustomerEntity;
import net.kdigital.ajaxTest.repository.CustomerRepository;

@Service
// final 객체는 생성자를 통해 초기화 시켜달라 
@RequiredArgsConstructor
public class CustomerService {
	private final CustomerRepository repository;

	/**
	 * 전달받은 DTO(w/o customerNum)를 DB에 저장한 후 
	 * 해당 레코드를 DTO 객체로 반환 (w/ customerNum)
	 * @param customerDTO
	 * @return
	 */
	public CustomerDTO insert(CustomerDTO customerDTO) {
		CustomerEntity entity = CustomerEntity.toEntity(customerDTO);
		// repository.save(): returns the saved entity 
		CustomerEntity savedEntity = repository.save(entity);
		
		return CustomerDTO.toDTO(savedEntity);
	}

	/**
	 * DB에 저장된 모든 데이터를 반환
	 * @return List<CustomerDTO>
	 */
	public List<CustomerDTO> selectAll() {
		List<CustomerEntity> entityList = repository.findAll(
				Sort.by(Sort.Direction.ASC, "customerNum"));
		List<CustomerDTO> result = new ArrayList<>();
		entityList.forEach((entity) -> result.add(CustomerDTO.toDTO(entity)));
		return result;
	}

	/**
	 * 전달받은 customerNum에 해당하는 데이터 삭제 
	 * @param customerNum
	 * @return boolean (삭제성공 여부)
	 */
	public boolean delete(Long customerNum) {
		repository.deleteById(customerNum);
		// 존재여부를 반환하는 메소드: existsById()
		return !(repository.existsById(customerNum));
	}
	

}
