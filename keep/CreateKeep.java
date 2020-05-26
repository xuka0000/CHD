import java.io.IOException;
import java.io.File;
/**
 * 处理上传svn 有空目录 无法上传的问题
 *
 * 说明 : svn 上传 码云项目中的空文件是无法上传的.
 *       本类是遍历项目下的所有文件夹,在空的文件下创建 .keep文件.
 *       使用之前先测试项目所在的本地路径是否是方法的 getRealPath()
 *       路径一致,如果不一致请自行修改.一定是项目名的路径.
 * author: huiping zhang
 * Date:2019/12/23 12:29
 **/
public class CreateKeep {
        public static final String packageFile = "C:\\Users\\凯凯\\IdeaProjects\\new";

        public static void main(String[] args) {
            String path = "C:\\Users\\凯凯\\eclipse-workspace\\Rainbow";
            System.out.println(path);
            File file = new File(path);
            try {
                traversalAllFolder(file);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /**
         * 遍历当前文件夹下的所有文件夹，对空的文件夹创建.keep文件
         *
         * @param dir
         * @throws Exception
         */
        final static void traversalAllFolder(File dir) throws Exception {
            File[] fs = dir.listFiles();
            int fsLength = fs.length;
            if (fsLength == 0) {
                createFile(dir.getAbsolutePath());
            } else {
                for (int i = 0; i < fsLength; i++) {
                    if (fs[i].isDirectory()) {
                        try {
                            traversalAllFolder(fs[i]);
                        } catch (Exception e) {
                        }
                    }
                }
            }
        }

        /**
         * 创建.keep文件
         *
         * @param folderPath
         *            路径名
         */
        public static void createFile(String folderPath) {
            String fileName = folderPath + "/" + packageFile;
            File file = new File(fileName);
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /**
         * 获取项目所在的绝对路径
         *
         * @return
         */
        public static String getRealPath() {
            String realPath = System.getProperty("user.dir");
            java.io.File file = new java.io.File(realPath);
            realPath = file.getAbsolutePath();
            try {
                realPath = java.net.URLDecoder.decode(realPath, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return realPath;
        }

    }
