package service;
import java.util.List;

public interface DAO<T> {
	//Insert
	public boolean add(T t);
	//Update
	public boolean update(T t);
	//Delete
	public boolean delete(int id);
	//Get All
	public List<T> getAll();
	//Get
	public T get(int id);
}