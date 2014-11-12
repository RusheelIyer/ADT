package com.gemsedu.adt;

public class BinaryNode<T extends Comparable>  {
	T data;
	BinaryNode<T> left;
	BinaryNode<T> right;
	
	public BinaryNode(T data) {
		this.data = data;
	}
}
