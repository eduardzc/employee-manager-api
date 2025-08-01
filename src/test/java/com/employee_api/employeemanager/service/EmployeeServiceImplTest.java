package com.employee_api.employeemanager.service;

import com.employee_api.employeemanager.exception.ResourceNotFoundException;
import com.employee_api.employeemanager.model.Employee;
import com.employee_api.employeemanager.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Unit tests for EmployeeServiceImpl")
public class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    private Employee test;

    @BeforeEach
    public void setUp(){
        test = new Employee(1L,"Eduardo Rodriguez", "eerc1310@gmail.com", "Batch developer");
    }

    @Test
    @DisplayName("Should return a list of employees when employees exist")
    public void shouldListAllEmployees_whenEmployeesExist(){
        //arrange
        when(employeeRepository.findAll()).thenReturn(List.of(test));
        //act
        List<Employee> result = employeeService.findAll();
        //assert
        assertEquals(1, result.size());
        assertEquals(test, result.get(0));
    }

    @Test
    @DisplayName("Should return an employee when the id exist")
    public void shouldReturnEmployee_whenEmployeeIdExist(){
        //
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(test));
        //act
        Employee result = employeeService.findById(1L);
        //assert
        assertNotNull(result);
        assertEquals("Eduardo Rodriguez", result.getName());
        //verify
        verify(employeeRepository).findById(1L);
    }

    @Test
    @DisplayName("Should return ResourceNotFoundException message")
    public void shouldThrowException_whenEmployeeNotFound(){
        when(employeeRepository.findById(50L)).thenReturn(Optional.empty());
        Exception exception = assertThrows(ResourceNotFoundException.class, () -> employeeService.findById(50L));
        assertTrue(exception.getMessage().contains("id:50 - Employee not found"));
        assertEquals("id:50 - Employee not found", exception.getMessage());
    }

    @Test
    @DisplayName("Should create a new employee when information input is valid")
    public void shouldCreateEmployee_whenValidInformationInput(){
        when(employeeRepository.save(test)).thenReturn(test);
        Employee saved = employeeService.create(test);

        assertNotNull(saved);
        assertEquals("Eduardo Rodriguez", saved.getName());

        verify(employeeRepository).save(test);

    }

    @Test
    @DisplayName("Should delete employee when ID is valid")
    public void shouldDeleteEmployee_whenIdIsValid(){
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(test));

        employeeService.delete(1L);

        verify(employeeRepository, times(1)).findById(1L);
        verify(employeeRepository, times(1)).delete(test);
    }

}
