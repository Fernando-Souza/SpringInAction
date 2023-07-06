
package com.estudo.spring.data;

import com.estudo.spring.dominio.TacoOrder;


public interface OrderRepository {
    
    TacoOrder save(TacoOrder order);
    
}
