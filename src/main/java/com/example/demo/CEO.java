package com.example.demo;

import com.google.cloud.spring.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;

@Entity(name = "CEOs")
public class CEO {
  @Id
  Long id;

  String name;

  String company;

  String industry;

  String ticker;

  String url;

  public CEO(String name, String company, String industry, String ticker, String url) {
    this.name = name;
    this.company = company;
    this.industry = industry;
    this.ticker = ticker;
    this.url = url;
  }

  public long getId() {
    return this.id;
  }
  
  public void setId(Long id) {
  	this.id=id;
  }
  
  public String getName() {
  	return this.name;
  }
  
  public void setName(String name) {
  	this.name=name;
  }
   public String getCompany() {
  	return this.company;
  }
  
  public void setCompany(String company) {
  	this.company=company;
  }
  
  public String getIndustry() {
  	return this.industry;
  }
  
  public void setIndustry(String industry) {
  	this.industry=industry;
  }

  public String getTicker() {
  	return this.ticker;
  }
  
  public void setTicker(String ticker) {
  	this.ticker=ticker;
  }

  public String getURL() {
  	return this.url;
  }
  
  public void setURL(String url) {
  	this.url=url;
  }
  

  @Override
  public String toString() {
    return "{" +
        "id:" + this.id +
        ", title:'" + this.name+ '\'' +
        ", author:'" + this.company + '\'' +
        ", year:" + this.industry + '\'' +
        ", ticker:" + this.ticker +
        '}';
  }
}