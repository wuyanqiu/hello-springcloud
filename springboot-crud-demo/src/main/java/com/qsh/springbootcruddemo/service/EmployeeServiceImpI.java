package com.qsh.springbootcruddemo.service;

import com.qsh.springbootcruddemo.dao.EmployeeDaoMapper;
import com.qsh.springbootcruddemo.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EmployeeServiceImpI implements EmployeeService {

    @Autowired
    private EmployeeDaoMapper employeeDaoMapper;

    @Autowired
    private RestTemplate restTemplate;

    private static final String SUCCESS = "success";

    private static final String FAILED = "failed";

    private static final String VERIFICATION_DIFFER = "verification_differ";

    private  static final String USER_NAME_REPEAT = "lastName_repeat";

    @Override
    public List<Employee> getAllEmp() {
        return employeeDaoMapper.getAllEmp();
    }

    @Override
    public Employee getOneEmp(String username) {
        return employeeDaoMapper.getOneEmp(username);
    }

    @Override
    public boolean addEmp(Employee employee) {
        Integer integer = employeeDaoMapper.addEmp(employee);
        if (integer != 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Employee getOneEmpById(Integer id) {
        return employeeDaoMapper.getOneEmpById(id);
    }

    @Override
    public boolean updateEmp(Employee employee) {
        Integer integer = employeeDaoMapper.updateEmp(employee);
        return integer != 0 ? true : false;
    }

    @Override
    public boolean deleteEmp(Integer id) {
        Integer integer = employeeDaoMapper.deleteEmp(id);
        return integer != 0 ? true : false;
    }


    @Override
    public String getVerification(Employee employee) {
        String regVerification =String.valueOf((int)((Math.random()*9+1)*100000));
        Integer cnkiResult = employeeDaoMapper.cnki(employee);
        if(cnkiResult>=1){
            return USER_NAME_REPEAT;
        }
        String getVerResult = getVerificate(employee ,regVerification);
        String addUserToDBResult = addUserToDB(employee,regVerification);
        System.out.println("addUserToDBResult:"+addUserToDBResult);
        if("ok".equals(getVerResult) && "success".equals(addUserToDBResult)){
            System.out.println("成功了要打印吧");
            return SUCCESS;
        }else {
            return FAILED;
        }
    }

    @Override
    public String regUser(Employee employee) {
        Employee userFormPage = employeeDaoMapper.getOneEmp(employee.getLastName());
        if(!userFormPage.getVerification().equals(employee.getVerification())){
            return VERIFICATION_DIFFER;
        }else {
            return employeeDaoMapper.regUser(employee)==1? SUCCESS:FAILED;
        }
    }

    /**
     * 调用发送邮件的服务，获取验证码
     * @param employee
     * @return
     */
    private String getVerificate(Employee employee, String regVerification){
        String url = "http://localhost:8765/sendEmail";
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
        paramMap.add("regVerification",regVerification);
        paramMap.add("email",employee.getEmail());
        String getVerificateResult = restTemplate.postForObject(url, paramMap, String.class);
        System.out.println("result1==================" + getVerificateResult);
        return getVerificateResult;
    }

    private String addUserToDB(Employee employee, String regVerification){
        MultiValueMap<String, Object> userMap = new LinkedMultiValueMap<>();
        userMap.add("lastname",employee.getLastName());
        userMap.add("email",employee.getEmail());
        userMap.add("verification",regVerification);
        String url = "http://localhost:8764/addUserToDb";
        String addUserResult = restTemplate.postForObject(url, userMap, String.class);
        System.out.println("result1==================" + addUserResult);
        return addUserResult;
    }
}
