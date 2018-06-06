/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bca.projetoaprendizado.util;

import java.util.Collection;

public interface Searchable<E, V> {

    public Collection<E> search(V value);

}
