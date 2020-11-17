/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.severs;

import java.util.List;

/**
 *
 * @author user
 */
public interface SaverInterface {
    public void save(List entityList, String entityName);
    public List load(String entityName);
}
