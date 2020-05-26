import java.io.IOException;
import java.io.File;
/**
 * �����ϴ�svn �п�Ŀ¼ �޷��ϴ�������
 *
 * ˵�� : svn �ϴ� ������Ŀ�еĿ��ļ����޷��ϴ���.
 *       �����Ǳ�����Ŀ�µ������ļ���,�ڿյ��ļ��´��� .keep�ļ�.
 *       ʹ��֮ǰ�Ȳ�����Ŀ���ڵı���·���Ƿ��Ƿ����� getRealPath()
 *       ·��һ��,�����һ���������޸�.һ������Ŀ����·��.
 * author: huiping zhang
 * Date:2019/12/23 12:29
 **/
public class CreateKeep {
        public static final String packageFile = "C:\\Users\\����\\IdeaProjects\\new";

        public static void main(String[] args) {
            String path = "C:\\Users\\����\\eclipse-workspace\\Rainbow";
            System.out.println(path);
            File file = new File(path);
            try {
                traversalAllFolder(file);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /**
         * ������ǰ�ļ����µ������ļ��У��Կյ��ļ��д���.keep�ļ�
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
         * ����.keep�ļ�
         *
         * @param folderPath
         *            ·����
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
         * ��ȡ��Ŀ���ڵľ���·��
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
