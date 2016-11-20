package num2string;

class App{
    public static void main(String[] args) {
        String test = "2000506603.46";
        NumMap numMap = new NumMap();
        Converter conversion = new Converter(numMap);
        conversion.setInput(test);
        conversion.Convert();
        System.out.println(conversion.getOutput());
    }
}
