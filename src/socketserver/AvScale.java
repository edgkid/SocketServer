/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketserver;

import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author Edgar
 */
public class AvScale {
    
    private ArrayList<String> avDecimal = null;
    private ArrayList<String> avImperial = null;
    private ArrayList<String> avLogmar = null;
    private ArrayList<String> avOriginalMetric = null;

    public AvScale() {
        
        this.avDecimal = new ArrayList<String>() {{
                add("0.1");
                add("0.13");
                add("0.17");
                add("0.20");
                add("0.25");
                add("0.33");
                add("0.40");
                add("0.50");
                add("0.63");
                add("0.80");
                add("1.00");
            }};
        
        this.avImperial = new ArrayList<String>() {{
                add("20/200");
                add("20/160");
                add("20/120");
                add("20/100");
                add("20/80");
                add("20/60");
                add("20/50");
                add("20/40");
                add("20/32");
                add("20/25");
                add("20/20");
            }};
        
        this.avLogmar = new ArrayList<String>(){{
                add("1.0");
                add("0.9");
                add("0.8");
                add("0.7");
                add("0.6");
                add("0.5");
                add("0.4");
                add("0.3");
                add("0.2");
                add("0.1");
                add("0.0");
        }};
        
        this.avOriginalMetric = new ArrayList<String>(){{
                add("6/60");
                add("6/48");
                add("6/36");
                add("6/30");
                add("6/24");
                add("6/18");
                add("6/15");
                add("6/12");
                add("6/9");
                add("6/8");
                add("6/6");
        }};
        
    }

    public ArrayList<String> getAvDecimal() {
        return avDecimal;
    }

    public void setAvDecimal(ArrayList<String> avDecimal) {
        this.avDecimal = avDecimal;
    }

    public ArrayList<String> getAvImperial() {
        return avImperial;
    }

    public void setAvImperial(ArrayList<String> avImperial) {
        this.avImperial = avImperial;
    }

    public ArrayList<String> getAvLogmar() {
        return avLogmar;
    }

    public void setAvLogmar(ArrayList<String> avLogmar) {
        this.avLogmar = avLogmar;
    }

    public ArrayList<String> getAvOriginalMetric() {
        return avOriginalMetric;
    }

    public void setAvOriginalMetric(ArrayList<String> avOriginalMetric) {
        this.avOriginalMetric = avOriginalMetric;
    }
    
    
    
    
    
}
