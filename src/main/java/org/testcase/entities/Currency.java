package org.testcase.entities;

import java.lang.String;

public class Currency {

  private String name;
  private double ExchangeRate;

  public Currency(java.lang.String name, double exchangeRate) {
    this.name = name;
    ExchangeRate = exchangeRate;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getExchangeRate() {
    return ExchangeRate;
  }

  public void setExchangeRate(double exchangeRate) {
    ExchangeRate = exchangeRate;
  }

  @Override
  public String toString() {
    return "Currency{" +
            "name='" + name + '\'' +
            ", ExchangeRate=" + ExchangeRate +
            '}';
  }
}
