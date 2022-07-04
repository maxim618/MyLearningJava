class Praktikum {
    public static void main(String[] args) {

        public static void main(String[] args) {
            int money = 500; // Деньги на корм
            int foodPerDay = 100; // Стоимость пачки корма
            int days = 0; // Дни, когда вы сможете покупать корм

            while(money>=0){
                days+=3;
                money = money - foodPerDay;
            } // Здесь опишите цикл, начинаем с 500 рублей
        ... // Здесь отразите, что вы будете покупать корм каждые три дня
       	...// Опишите строку вывода
        ...// Цикл оканчивается здесь

            System.out.println("Денег хватит на " + ... + " дней.");
}