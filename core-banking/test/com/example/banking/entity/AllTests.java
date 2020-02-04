package com.example.banking.entity;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
@RunWith(JUnitPlatform.class)
@SelectClasses({ AccountTest.class, CheckingAccountTest.class })
public class AllTests {

}
