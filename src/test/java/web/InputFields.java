package web;

public enum InputFields {
    FIRST_NAME {
        public String toString() {
            return "First Name";
        }
    },

    LAST_NAME {
        public String toString() {
            return "Last Name";
        }
    },

    PHONE {
        public String toString() {
            return "Phone #";
        }
    },
}
