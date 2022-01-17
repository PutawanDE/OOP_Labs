package com.PutawanDE.OOP_Lab16;

public interface Observable<E> {
    void subscribe(Observer<E> observer);
}
