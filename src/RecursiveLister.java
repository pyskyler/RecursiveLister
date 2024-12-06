import java.io.File;

public class RecursiveLister
{
    private File[] files;
    private StringBuilder sb;

    public RecursiveLister(File directory)
    {
        files = directory.listFiles();
        sb = new StringBuilder();
    }

    public void list()
    {
        listFiles(sb);
    }

    private StringBuilder listFiles(StringBuilder sb)
    {
        this.sb = sb;
        for (File file : files)
        {
            String fileName = file.toString();
            if (file.isDirectory())
            {
                RecursiveLister lister = new RecursiveLister(file);
                this.sb = lister.listFiles(sb);
            }
            else {
                sb.append(fileName).append("\n");
            }
        }
        return sb;
    }

    public StringBuilder getSb()
    {
        return sb;
    }
}