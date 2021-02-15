package com.lavender.BitCoin.model;


public class Bitcoin {
    private String volume24;
    private String volume24a;
    private String market_cap_usd;
    private String csupply;
    private String msupply;
    private String tsupply;
    private String name;
    private String symbol;
    private String price;
    private String pricebtc;
    private String percen24h;
    private String percen7d;

    public Bitcoin() {
    }

    public Bitcoin(String name, String symbol, String price, String pricebtc, String percen24h, String percen7d, String volume24, String volume24a, String market_cap_usd, String tsupply, String msupply, String csupply) {
        this.name = name;
        this.symbol = symbol;
        this.price = price;
        this.pricebtc = pricebtc;
        this.percen24h = percen24h;
        this.percen7d = percen7d;
        this.volume24a = volume24a;
        this.volume24 = volume24;
        this.market_cap_usd = market_cap_usd;
        this.csupply = csupply;
        this.msupply = msupply;
        this.tsupply = tsupply;
    }


    public String getVolume24() {
        return volume24;
    }

    public void setVolume24(String volume24) {
        this.volume24 = volume24;
    }

    public String getVolume24a() {
        return volume24a;
    }

    public String getMarket_cap_usd() {
        return market_cap_usd;
    }

    public void setMarket_cap_usd(String market_cap_usd) {
        this.market_cap_usd = market_cap_usd;
    }

    public String getCsupply() {
        return csupply;
    }

    public void setCsupply(String csupply) {
        this.csupply = csupply;
    }

    public String getMsupply() {
        return msupply;
    }

    public void setMsupply(String msupply) {
        this.msupply = msupply;
    }

    public String getTsupply() {
        return tsupply;
    }

    public void setTsupply(String tsupply) {
        this.tsupply = tsupply;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPriceBtc() {
        return pricebtc;
    }

    public void setPriceBtc(String percen1h) {
        this.pricebtc = percen1h;
    }

    public String getPercen24h() {
        return percen24h;
    }

    public void setPercen24h(String percen24h) {
        this.percen24h = percen24h;
    }

    public String getPercen7d() {
        return percen7d;
    }

    public void setPercen7d(String percen7d) {
        this.percen7d = percen7d;
    }
}
