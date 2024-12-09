package com.example.demo;

import java.util.List;

import com.google.common.collect.Lists;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@SpringBootApplication
public class DemoApplication {
  @Autowired
  CEORepository ceoRepository;

  public static void main(String[] args) {
     SpringApplication.run(DemoApplication.class, args);
  }

  @ShellMethod(value = "Saves a CEO to Cloud Datastore: saveCEO <name> <company> <industry> <ticker>, <url>", key = "saveCEO")
  public String saveCEO(String name, String company, String industry, String ticker, String url) {
     CEO savedCEO = this.ceoRepository.save(new CEO(name, company, industry, ticker, url));
     return savedCEO.toString();
}

  @ShellMethod(value = "Shows the data for all the CEOS", key = "findAllCEOs")
  public String findAllCEOs() {
     Iterable<CEO> CEOs = this.ceoRepository.findAll();
     return Lists.newArrayList(CEOs).toString();
  }

//   @ShellMethod("Saves a book to Cloud Datastore: save-book <title> <author> <year>")
//   public String saveCEO(String name, String company, String industry, String ticker, String url) {
//      CEO savedCEO = this.ceoRepository.save(new CEO(name, company, industry, ticker, url));
//      return savedCEO.toString();
//   }

//   @ShellMethod("Loads all books")
//   public String findAllBooks() {
//      Iterable<CEO> books = this.ceoRepository.findAll();
//      return Lists.newArrayList(books).toString();
//   }

//   @ShellMethod("Loads books by author: find-by-author <author>")
//   public String findByAuthor(String author) {
//      List<CEO> books = this.bookRepository.findByAuthor(author);
//      return books.toString();
//   }

//   @ShellMethod("Loads books published after a given year: find-by-year-after <year>")
//   public String findByYearAfter(int year) {
//      List<CEO> books = this.bookRepository.findByYearGreaterThan(year);
//      return books.toString();
//   }

//   @ShellMethod("Loads books by author and year: find-by-author-year <author> <year>")
//   public String findByAuthorYear(String author, int year) {
//      List<CEO> books = this.bookRepository.findByAuthorAndYear(author, year);
//      return books.toString();
//   }

//   @ShellMethod("Removes all books")
//   public void removeAllBooks() {
//      this.bookRepository.deleteAll();
//   }
}
