/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests;

import beans.Parrot;
import beans.Person;
import config.ProjectConfig;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 *
 * @author earltstephens
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ProjectConfig.class })
public class AppTests {
    
    @Autowired
    private ApplicationContext context;
    
    @Test
    public void testKokoIsInSpringContext() {
        Parrot p = context.getBean(Parrot.class);
        
        assertEquals("Koko", p.getName());
    }
    
    @Test
    public void testEllaIsInSpringContext() {
        Person p = context.getBean(Person.class);
        
        assertEquals("Ella", p.getName());
    }
    
    @Disabled
    @Test
    public void testEllaDoesNotOwnKoko() {
        Person p = context.getBean(Person.class);
        
        assertNull(p.getParrot());
    }
    
    @Test
    public void testEllaOwnsKoko() {
        Person p = context.getBean(Person.class);
        
        assertNotNull(p.getParrot());
    }
}
