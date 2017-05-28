import java.io.File;
import java.util.Date;

//lオプション
public class Loption{
    Files file;

    public Loption(String[] args) {
        this.file = new Files(args);
    }

    public void run(){
        file.getOption();

        if(file.opt().contains('r')) {
            for(int i = 0; i < file.getFiles().length; i++) {
                if(file.opt().contains('a')) {
                    if(file.list().get(i).isHidden()) {
                        showFileInfo(file.list().get(i));
                    }
                }
                if(!file.list().get(i).isHidden()) {
                    showFileInfo(file.list().get(i));
                }
            }
        } else {
            for(File f: file.getArrayFile()) {
                if(file.opt().contains('a')) {
                    if(f.isHidden()) {
                        showFileInfo(f);
                    }
                }
                if(!f.isHidden()) {
                    showFileInfo(f);
                }
            }
        }

    }

    private void showFileInfo(File target){
//        if(target.exists()){ // ファイルが存在する場合．
            this.showInfo(target);
//        }
//        else{
            // 指定されたファイル名は存在しない旨を出力する．
//            System.out.printf("FileInfo: %s: No such file or directory%n", target.getName());
//        }
    }

    private void showInfo(File target){
        System.out.printf(
                "%s %6d %s %s%n",
                getMode(target),
                target.length(),
                new Date(target.lastModified()),
                target.getName()
        );
    }

    private String getMode(File file){
        String rwx = "";
        // 読み込み権限があるか確認する．
        if(file.canRead()) rwx += "r";
        else     rwx += "-";

        // 書き込み権限があるか確認する．
        if(file.canWrite()) rwx += "w";
        else     rwx += "-";

        // 実行権限があるか確認する．
        if(file.canExecute()) rwx += "w";
        else     rwx += "-";

        return rwx;
    }

}
