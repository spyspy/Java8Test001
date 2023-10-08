package justtest;

import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;

public class SmbTest {
    public static void main(String[] args) throws IOException {
        File fileSource = new File("C:\\example\\xcode.txt");
        SmbFile smbFileTarget = new SmbFile("path", "example.txt");
// input and output stream
        FileInputStream fis = new FileInputStream(fileSource);
        SmbFileOutputStream smbfos = new SmbFileOutputStream(smbFileTarget);
// writing data
        try {
            // 16 kb
            final byte[] b  = new byte[16*1024];
            int read = 0;
            while ((read=fis.read(b, 0, b.length)) > 0) {
                smbfos.write(b, 0, read);
            }
        }
        finally {
            fis.close();
            smbfos.close();
        }
    }
}
