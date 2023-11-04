package com.actitime.qa.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\fathi\\OneDrive\\Desktop\\UCSC\\IS_FouthYear_Sem1\\IS4102 Advanced Software Quality Assurance\\Assignment 2\\19020368_assignment2\\Section3\\TestAddNewUser\\src\\main\\java\\com\\actitime\\qa\\feature\\CreateNewUser.feature"  //feature file location
		,glue={"com/actitime/qa/stepdefinitions"}
		,monochrome = true,
				strict=true,
				dryRun=false
				
		)




public class TestRunner {}
