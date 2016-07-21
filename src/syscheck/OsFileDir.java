/*
 *  This class can be either a file or a direcotry
 */
package syscheck;

 
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Set;
 
/**
 *
 * @author wangc
 */
public class OsFileDir {
    private String Permission;
    private String owner;
    private String group;
    private Double freeMb;
    private Boolean isDir;
    
    public OsFileDir(String fileDirPath) throws Exception {
        Path path = Paths.get(fileDirPath);
        this.isDir = Files.isDirectory(path);
 
         
        
        listPermissions(path);
    }
    
     private static void listPermissions(Path path) throws Exception {
    System.out.println("Permission for " + path.getFileName());
    PosixFileAttributeView view = Files.getFileAttributeView(path,
        PosixFileAttributeView.class);

    PosixFileAttributes attributes = view.readAttributes();

    System.out.println("Group: " + attributes.group().getName());
    System.out.println("Owner: " + attributes.owner().getName());

    Set<PosixFilePermission> permissions = attributes.permissions();
    

    System.out.print("Permissions: ");
    for (PosixFilePermission permission : permissions) {
      System.out.print(permission.name() + " ");
    }
  }
}
