public enum Queries {
    ;

    //P02 Get Villains’ Names
    static final String GET_VILLAINS_NAMES_AND_MINION_COUNT = "select `name`, count(distinct `minion_id`) as 'minions_count' from villains as v" +
            " join minions_villains mv on v.id = mv.villain_id" +
            " group by v.`id`" +
            " HAVING `minions_count` > ?" +
            " order by `minions_count` desc;";

    //P03 Get Minion Names
    static  final String GET_VILLAIN_NAME_BY_ID = "select `name` from villains" +
            " where `id` = ?;";
    static final String GET_MINIONS_NAME_AND_AGE = "select m.`name`, m.`age` from minions as m" +
            " join minions_villains mv on m.id = mv.minion_id" +
            " join villains v on v.id = mv.villain_id" +
            " where v.id = ?;";

    //P04 Add Minion
    static final String GET_TOWN_ID_BY_NAME = "select `id` from towns where `name` = ?;";
    static final String GET_VILLAIN_ID_BY_NAME = "select `id` from villains where `name` = ?;";
    static final String INSERT_INTO_VILLAINS = "insert into villains (`name`, `evilness_factor`) value (?, ?);";
    static final String INSERT_INTO_TOWNS = "insert into towns (`name`) value (?);";
    static final String INSERT_INTO_MINIONS = "insert into `minions`(`name`, `age`, `town_id`) value(?, ?, ?);";
    static final String GET_MINION_ID_BY_NAME = "select `id` from minions where `name` = ?;";
    public static final String INSERT_MINIONS_VILLAINS = "insert into minions_villains (`minion_id`, `villain_id`) value (?, ?)";

    //P05 Change Town Names Casing
    public static final String CHANGE_TOWN_NAME_CASE = "update towns set name = UPPER(name) where country = ?;";
    public static final String SELECT_TOWN_BY_COUNTRY = "select name from towns where country = ?;";

    //P06 Remove Villain
    public static final String GET_MINION_COUNT_BY_VILLAIN_ID = "select count(minion_id) as count from minions_villains where villain_id = ?;";
    public static final String REMOVE_MINIONS_VILLAINS_BY_VILLAIN_ID = "delete from minions_villains where villain_id = ?;";
    public static final String REMOVE_VILLAIN_BY_ID = "delete from villains where id = ?;";

    //P07 Print All Minion Names
    public static final String GET_ALL_MINIONS_NAMES = "select name from minions;";

    //P08 Increase Minions Age
    public static final String UPDATE_MINIONS_NAME_AGE_BY_ID = "update minions set age = age + 1, name = LOWER(name) where id = ?;";
    public static final String GET_ALL_MINIONS_NAME_AGE = "select name, age from minions;";

    //P 09 Increase Age Stored Procedure
    public static final String CALL_INCREASE_AGE_PROCEDURE = "call usp_get_older(?);";
    public static final String GET_MINION_NAME_AGE_BY_ID = "select name, age from minions where id = ?;";
}
