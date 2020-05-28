// copyright www.codejava.net
package com.demo;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
@Service
@Transactional
public class NadzorService {
 
    @Autowired
    private NadzorRepository reponadzor;
     
    public List<Test_nadzor> listAll() {
        return reponadzor.findAll();
    }
     
    public void save(Test_nadzor testnadzor) {
    	reponadzor.save(testnadzor);
    }
     
    public Test_nadzor get(long id) {
        return reponadzor.findById(id).get();
    }
     
    public void delete(long id) {
    	reponadzor.deleteById(id);
    }
}