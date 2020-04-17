/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

/**
 *
 * @author x0v20
 */
public class Die
{
    int outcome;
    
    void roll()
    {
        double x = Math.random();
        x = 1.0 + (x * 6.0);
        
        outcome = (int)Math.floor(x);
    }    
}
