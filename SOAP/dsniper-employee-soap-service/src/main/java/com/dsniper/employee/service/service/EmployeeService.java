package com.dsniper.employee.service.service;

import com.dsniper.employee.service.model.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService {

    private final Map<Integer, Employee> employeeRepo = new HashMap<>();

    @Value("${file.storage.location}")
    private String storagePath;

    public EmployeeService() {
        employeeRepo.put(1, new Employee(1, "Buddy", "Architect", 100000));
        employeeRepo.put(2, new Employee(2, "Mohan", "Developer", 60000));
    }

    public Employee getEmployee(int id) {
        return employeeRepo.get(id);
    }

    public boolean addEmployee(Employee e) {
        employeeRepo.put(e.getId(), e);
        return true;
    }

    public boolean updateEmployee(Employee e) {
        if (!employeeRepo.containsKey(e.getId())) return false;
        employeeRepo.put(e.getId(), e);
        return true;
    }

    public boolean deleteEmployee(int id) {
        return employeeRepo.remove(id) != null;
    }

    public boolean uploadDocument(int empId, String fileName, byte[] fileContent) {
        try {
            File dir = new File(storagePath);
            if (!dir.exists()) dir.mkdirs();
            FileOutputStream fos = new FileOutputStream(storagePath + "/" + empId + "_" + fileName);
            fos.write(fileContent);
            fos.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public byte[] downloadDocument(int empId, String fileName) {
        try {
            File file = new File(storagePath + "/" + empId + "_" + fileName);
            if (!file.exists()) return null;
            return Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            return null;
        }
    }
}
