
public class ListCommand {

    public static void main(String[] args) {
        Files f = new Files(args);

        if(args[0].equals("ls")) {
            if(args.length == 1) {
                f.getNames();
            } else {
                f.getOption();

                if(f.opt().contains('l')) {
                    Loption loption = new Loption(args);
                    loption.run();
                } else if (f.opt().contains('a') || f.opt().contains('t') || f.opt().contains('r')) {
                    f.getNames();
                }
            }
        } else {
            System.out.println(args[0] + ": command not found");
        }
    }

}

