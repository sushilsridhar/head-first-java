package chap14;


public class QuizCard
{
    private String question;
    private String answer;

    public QuizCard(String question,String answer)
    {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion()
    {
        return question;
    }
    public void setQuestion(String q)
    {
        this.question = q;
    }

    public String getAnswer()
    {
        return answer;
    }
    public void setAnswer(String a)
    {
        this.answer = a;
    }

}
