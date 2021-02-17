package model.data_structures;

public class Nodo<T> 
{
	private Nodo<T> siguiente;
	private T item;

	public Nodo(T item)
	{
		siguiente = null;
		this.item = item;
	}
	public Nodo<T> darSig()
	{
		return siguiente;
	}
	public void setSigNodo(Nodo<T> siguiente)
	{
		this.siguiente = siguiente;
	}
	public T darItem()
	{
		return item;
	}
	public void setItem(T item)
	{
		this.item = item;
	}
	public void agregar(T item) 
	{
		
	}

}
