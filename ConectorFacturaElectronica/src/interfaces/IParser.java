/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author luis.arce
 */
public interface IParser {
    void procesarFactura(String rawFactura, String[] lineasFactura);
}
