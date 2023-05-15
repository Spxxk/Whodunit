package zork;

public class Constants {
    public enum ArgumentCount {
        INFINITE (-1),
        ONE (1),
        NONE (0);

        private final int args;

        ArgumentCount(int n) {
            args = n;
        }

        public int argCount() {
            return args;
        }
    }
}
