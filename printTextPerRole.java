/**
 * Created by Vsevolod on 28/09/16.
 * <p>
 * <code>printTextPerRole!</code>
 *
 * @author Vsevolod
 * @version 1.0
 */

public class printTextPerRole {
    public static void main(String[] args) {

        String[] roles = {
                "Городничий",
                "Аммос Федорович",
                "Артемий Филиппович",
                "Лука Лукич"};

        String[] textLines = {
                "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                "Аммос Федорович: Как ревизор?",
                "Артемий Филиппович: Как ревизор?",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!",
                "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!"
        };

        System.out.println(printTextPerRole(roles, textLines));
    }

    private static String printTextPerRole(String[] roles, String[] textLines) {

        int i;
        int j;
        int index = 1;

        String temp;
        StringBuilder[] rolesWithText = new StringBuilder[roles.length];
        StringBuilder result = new StringBuilder(50000);


        for (j = 0; j < roles.length; j++){
            roles[j] = roles[j] + ':';
            rolesWithText[j] = new StringBuilder(2000);
            rolesWithText[j].append("\n");
            rolesWithText[j].append(roles[j]);
        }

        for (i = 0; i < textLines.length; i++){

            for (j = 0; j < roles.length; j++){
                if(textLines[i].startsWith(roles[j])){
                    temp = textLines[i].replaceFirst(roles[j], "");
                    rolesWithText[j].append('\n');
                    rolesWithText[j].append(index);
                    rolesWithText[j].append(')');
                    rolesWithText[j].append(temp);
                    ++index;
                    break;
                }
            }

        }

        for (j = 0; j < roles.length; j++){
            result.append(rolesWithText[j]);
            result.append('\n');
        }

        return result.toString();
    }
}
