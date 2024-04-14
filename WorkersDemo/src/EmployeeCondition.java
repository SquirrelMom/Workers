public enum EmployeeCondition {
    PRESENT {
        @Override public String toString() {
            return "present";
        }
        },
    DELEGATION {
            @Override public String toString() {
                return "delegation";
        }
        },
    SICK {
        @Override public String toString() {
            return "sick";
        }
    },
    ABSENT {
        @Override public String toString() {
            return "absent";
        }
    }
}
