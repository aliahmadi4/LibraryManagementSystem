package dataaccess;


public interface DataAccess {
	public void saveLibraryMember(String name, LibraryMember member);
	public LibraryMember readLibraryMember(String name);
}
