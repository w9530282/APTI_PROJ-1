package com.android.smarttest.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.android.smarttest.model.CandidateObj;
import com.android.smarttest.model.EmployeeObj;
import com.android.smarttest.model.PointofContactObj;
import com.android.smarttest.model.Question;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "smart_test.db";
    // tasks table name
    private static final String TABLE_QUEST = "quest";
    private static final String TABLE_QUESTTWO = "questtwo";
    private static final String TABLE_QUESTTHREE = "questthree";
    private static final String TABLE_QUESTFOUR = "questfour";
    private static final String TABLE_QUESTFIVE = "questfive";
    private static final String TABLE_QUESTSIX = "questsix";
    private static final String TABLE_QUESTSEVEN = "questseven";
    private static final String TABLE_QUESTEIGHT = "questeight";
    private static final String TABLE_QUESTNINE = "questnine";
    private static final String TABLE_QUESTTEN = "questten";
    // tasks Table Columns names
    private static final String KEY_ID = "qid";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; // correct option
    private static final String KEY_OPTA = "opta"; // option a
    private static final String KEY_OPTB = "optb"; // option b
    private static final String KEY_OPTC = "optc"; // option c
    private SQLiteDatabase sqLiteDatabase;

    //Candidate columns
    private static final String COLUMN_C_CODE = "c_code";
    private static final String COLUMN_C_NAME = "c_name";
    private static final String COLUMN_C_EMAIL = "c_email";
    private static final String COLUMN_C_NUMBER = "c_number";
    private static final String COLUMN_C_TECHNOLOGY = "c_technology";
    private static final String COLUMN_C_EMP_ID = "emp_id";
    private static final String COLUMN_C_EMP_NAME = "name";
    private static final String COLUMN_C_RESULT = "result";
    private static final String COLUMN_C_SCORE = "score";


    //Employee columns
    private static final String COLUMN_EMP_ID = "emp_id";
    private static final String COLUMN_EMP_NAME = "name";
    private static final String COLUMN_EMP_DESIGNATION = "designation";

    //Table Names
    private static final String TABLE_CANDIDATE = "CANDIDATE";
    private static final String TABLE_EMPLOYEE = "EMPLOYEE";


    private String SELECT_CANDIDATE_QUERY = "select * from CANDIDATE WHERE c_code=?";
    private String SELECT_CANDIDATE_BY_EMP_QUERY = "select * from CANDIDATE";
    private String SELECT_ALL_EMP_QUERY = "select * from EMPLOYEE";
    private String SELECT_EMP_QUERY = "select * from EMPLOYEE WHERE emp_id=?";

    private String SELECT_CANDIDATE_BY_EMP_CODE_QUERY = "select * from CANDIDATE c WHERE c.emp_id=?";

    private String CREATE_TABLE_CANDIDATE = "CREATE TABLE IF NOT EXISTS CANDIDATE (_id INTEGER PRIMARY KEY AUTOINCREMENT, c_code TEXT, c_name TEXT, c_email TEXT, c_number TEXT, c_technology TEXT, emp_id TEXT, name TEXT, result TEXT, score TEXT);";
    private String CREATE_TABLE_EMPLOYEE = "CREATE TABLE IF NOT EXISTS EMPLOYEE (_id INTEGER PRIMARY KEY AUTOINCREMENT, emp_id TEXT, name TEXT, designation TEXT);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        sqLiteDatabase = db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "
                + KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT)";
        db.execSQL(sql);
        db.execSQL(CREATE_TABLE_CANDIDATE);
        db.execSQL(CREATE_TABLE_EMPLOYEE);
        loadQuestions();

        String sqltwo = "CREATE TABLE IF NOT EXISTS " + TABLE_QUESTTWO + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "
                + KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT)";
        db.execSQL(sqltwo);
        db.execSQL(CREATE_TABLE_CANDIDATE);
        db.execSQL(CREATE_TABLE_EMPLOYEE);
        loadQuestionstwo();

        String sqlthree = "CREATE TABLE IF NOT EXISTS " + TABLE_QUESTTHREE + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "
                + KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT)";
        db.execSQL(sqlthree);
        db.execSQL(CREATE_TABLE_CANDIDATE);
        db.execSQL(CREATE_TABLE_EMPLOYEE);
        loadQuestionsthree();

        String sqlfour = "CREATE TABLE IF NOT EXISTS " + TABLE_QUESTFOUR + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "
                + KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT)";
        db.execSQL(sqlfour);
        db.execSQL(CREATE_TABLE_CANDIDATE);
        db.execSQL(CREATE_TABLE_EMPLOYEE);
        loadQuestionsfour();

        String sqlfive = "CREATE TABLE IF NOT EXISTS " + TABLE_QUESTFIVE + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "
                + KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT)";
        db.execSQL(sqlfive);
        db.execSQL(CREATE_TABLE_CANDIDATE);
        db.execSQL(CREATE_TABLE_EMPLOYEE);
        loadQuestionsfive();

        String sqlsix = "CREATE TABLE IF NOT EXISTS " + TABLE_QUESTSIX + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "
                + KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT)";
        db.execSQL(sqlsix);
        db.execSQL(CREATE_TABLE_CANDIDATE);
        db.execSQL(CREATE_TABLE_EMPLOYEE);
        loadQuestionssix();

        String sqlseven = "CREATE TABLE IF NOT EXISTS " + TABLE_QUESTSEVEN + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "
                + KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT)";
        db.execSQL(sqlseven);
        db.execSQL(CREATE_TABLE_CANDIDATE);
        db.execSQL(CREATE_TABLE_EMPLOYEE);
        loadQuestionsseven();

        String sqleight = "CREATE TABLE IF NOT EXISTS " + TABLE_QUESTEIGHT + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "
                + KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT)";
        db.execSQL(sqleight);
        db.execSQL(CREATE_TABLE_CANDIDATE);
        db.execSQL(CREATE_TABLE_EMPLOYEE);
        loadQuestionseight();

        String sqlnine = "CREATE TABLE IF NOT EXISTS " + TABLE_QUESTNINE + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "
                + KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT)";
        db.execSQL(sqlnine);
        db.execSQL(CREATE_TABLE_CANDIDATE);
        db.execSQL(CREATE_TABLE_EMPLOYEE);
        loadQuestionsnine();

        String sqlten = "CREATE TABLE IF NOT EXISTS " + TABLE_QUESTTEN + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "
                + KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT)";
        db.execSQL(sqlten);
        db.execSQL(CREATE_TABLE_CANDIDATE);
        db.execSQL(CREATE_TABLE_EMPLOYEE);
        loadQuestionsten();
    }

    private void loadQuestions() {
        Question q1 = new Question("In final exam of class IX there are 130 students 20 % students failed. How many students passed to class\n" +
                "X?", "104", "112", "117", "104");
        this.addQuestion(q1);
        Question q2 = new Question("Sanjay gets 72 % marks in examinations. If these are 864 marks, find the maximum marks", "1050", "860", "1200", "1200");
        this.addQuestion(q2);
        Question q3 = new Question("In a college of 1335 students, 60 % are boys. Find the number of girls and number of boys in the college?", "924,221", "691,404", "534,801", "534,801");
        this.addQuestion(q3);
        Question q4 = new Question("A foot ball team lost 75 % of the matches it played. If it won 45 matches, find the number of matches it played.", "120", "180", "145", "180");
        this.addQuestion(q4);
        Question q5 = new Question("Brother's weight is 25 % more than that of sister. What percent is brother’s weight less than sister's weight?", "25%", "20%", "98%", "98%");
        this.addQuestion(q5);
        Question q6 = new Question("Mouli had $ 3600 left after spending 40 % of the money he took for shopping. How much money did he\n" +
                "take along with him?", "2500", "6000", "4500", "6000");
        this.addQuestion(q6);
        Question q7 = new Question("Mithun went to a shop and bought things worth Rs. 75, out of which 90 Paise went on sales tax on taxable\n" +
                "purchases. If the tax rate was 18%, then what was the cost of the tax free items?", "69.1", "34.5", "12.5", "69.1");
        this.addQuestion(q7);
        Question q8 = new Question("Gowthaman needs 25% to pass. If he scored 424 marks and falls short by 26 marks, what was the\n" +
                "maximum marks he could have got?", "2725", "2650", "1800", "1800");
        this.addQuestion(q8);
        Question q9 = new Question(" In an exam Aashika secured 1328 marks. If she secured 32 % marks, find the maximum marks.", "1298", "4150", "4400", "4150");
        this.addQuestion(q9);
        Question q10 = new Question("A number is increased by 70 % and then decreased by 70 %. Find the net increase or decrease per cent.", "49", "25", "56", "49");
        this.addQuestion(q10);
        Question q11 = new Question("Nandhini scored 996 marks out of 1200 marks and her elder brother Kalyan scored 1020 marks out of 1500 marks. Find the scored percentage which is better?", "68%", "83%", "65%", "68%");
        this.addQuestion(q11);

    }

    private void loadQuestionstwo() {
        Question q1 = new Question("In how many ways can the letters of the word 'NOMINATION' be arranged?", "151200", "237672", "150720", "151200");
        this.addQuestiontwo(q1);
        Question q2 = new Question("How many words can be formed by using all letters of the word 'CABIN'?", "105", "860", "120", "120");
        this.addQuestiontwo(q2);
        Question q3 = new Question("How many arrangements can be made out of the letters of the word 'BIGBOSS'?", "1260", "9240", "1820", "1260");
        this.addQuestiontwo(q3);
        Question q4 = new Question("In how many different ways can the letters of the word 'GRINDER' be arranged?", "2520", "1280", "3605", "2520");
        this.addQuestiontwo(q4);
        Question q5 = new Question("In how many different ways can any 4 letters of the word 'ABOLISH' be arranged?", "5040", "840", "24", "840");
        this.addQuestiontwo(q5);
        Question q6 = new Question("In how many different ways can the letters of the word 'ABOMINABLES' be arranged so that the vowels always come together?", "151200", "181045", "201440", "151200");
        this.addQuestiontwo(q6);
        Question q7 = new Question("In how many different ways can the letters of the word 'POTENCY' be arranged in such a way that the vowels always come together?", "1360", "2480", "5040", "1440");
        this.addQuestiontwo(q7);
        Question q8 = new Question("In how many different ways can the letters of the word 'RAPINE' be arranged in such a way that the vowels occupy only the odd positions?", "32", "48", "36", "36");
        this.addQuestiontwo(q8);
        Question q9 = new Question("In how many different ways can the letters of the word 'SPORADIC' be arranged so that the vowels always come together?", "4320", "1202", "1720", "4320");
        this.addQuestiontwo(q9);
        Question q10 = new Question("How many different possible permutations can be made from the word ‘WAGGISH’ such that the vowels are never together?", "3605", "3120", "1800", "1800");
        this.addQuestiontwo(q10);
        Question q11 = new Question("In how many different ways can the letters of the word POMADE be arranged in such a way that the vowels occupy only the odd positions?", "72", "144", "532", "36");
        this.addQuestiontwo(q11);
        Question q12 = new Question("In how many different ways can the letters of the word 'DILUTE' be arranged such that the vowels may appear in the even places?", "36", "720", "144", "36");
        this.addQuestiontwo(q12);

    }

    private void loadQuestionsthree() {
        Question q1 = new Question("Two faucet can fill a tank in 12hours and 16 hours .While a third faucet empties the full tank in 24 hours.If all the three faucet are operate simultaneously, In how much time  will the tank be filled ?", "4hrs:12mins", "4hrs:48mins", "9hrs:36mins", "9hrs:36mins");
        this.addQuestionthree(q1);
        Question q2 = new Question(" A tube can fill a cistern in 18hrs.After half the cistern is filled, three more similar tubes are opened. What is the total time taken to fill the cistern completely ? ", "9hrs:52mins", "9hrs:45mins", "10hrs:30mins", "10hrs:30mins");
        this.addQuestionthree(q2);
        Question q3 = new Question(" Two taps can fill a tank in 4 hours and 5 hours .If two taps are operate simultaneously, In how much time  will the tank be filled ? ", "4hrs:18mins", "10hrs:12mins", " 2hrs 13min ", " 2hrs 13min ");
        this.addQuestionthree(q3);
        Question q4 = new Question(" Two faucet  p and q  can fill a tank in 10 minutes and 20 minutes.If both faucet are opened simultaneously , after how much time should q be closed  so that the tank is full in 9 minutes ? ", " 2 min ", "4min", "6min", "2min");
        this.addQuestionthree(q4);
        Question q5 = new Question(" A pipe can fill the tank in  12 hours.Because of a leak in the tank it took 16(1/2) hours to fill the tank.If the tank is full,how much time will the leak take to empty it? ", " 18hrs51mins ", "12hrs49mins", "13hrs23mins", " 18hrs51mins ");
        this.addQuestionthree(q5);
        Question q6 = new Question(" One tap can fill a tank thrice as fast as another tap. If together  the two taps can fill the tank in 12 minutes, then the slower tap alone will be able to fill the tank in ", " 32min ", "20min", "15min", " 32min ");
        this.addQuestionthree(q6);
        Question q7 = new Question(" Two pipes can fill a dumper in 8 hours and 24 hours .If two pipes are operate simultaneously, In how much time  will the dumper be filled ? ", " 6 hrs ", "4hrs", "5hrs", " 6 hrs ");
        this.addQuestionthree(q7);
        Question q8 = new Question(" A tube can fill a tank completely in 18 hours. After half the tank is filled , one more similar tube is opened.   What is the total time taken to fill the tank completely ? ", " 13hrs 30min ", "2hrs10mins", "10hrs20mins", " 13hrs 30min ");
        this.addQuestionthree(q8);
        Question q9 = new Question(" A tap can fill a cistern in 11hours, but due to a leakage it took 13hours to fill the cistern.  If the cistern is full, in what time will the cistern become empty due to leakage ? ", " 71.5 hrs ", "77.4hrs", "42.3hrs", " 71.5 hrs ");
        this.addQuestionthree(q9);
        Question q10 = new Question(" Two faucet P and Q can fill a tank in 10 min. and 20 min. respectively. A water faucet R can empty the tank in 10 min. First P and Q are opened. After 3 min, R is also opened. In how much time, the tank is full? ", "5m", " 11m ", "40m", " 11m ");
        this.addQuestionthree(q10);
        Question q11 = new Question(" Two filling tap can fill a dumper in 14 and 28 min. respectively and when the waste tap is open, they can together fill it in 35 min. The waste pipe can empty the full dumper in – ", "130/12hrs", " 140/11 hrs. ", "100/5hrs", " 140/11 hrs. ");
        this.addQuestionthree(q11);

    }

    private void loadQuestionsfour() {
        Question q1 = new Question(" In a 2280 m race Dinesh beats Aarav by 360 m or 6 seconds. In another race on the same track at the same speeds. Aarav and karthick start at one end while Dinesh starts at the opposite end. How many metres would Aarav have covered ,by the time Dinesh meets karthick  given that Dinesh speed is 16 m/sec more than that of karthick ", " 2280 m ", "8840m", "1345m", " 2280 m ");
        this.addQuestionfour(q1);
        Question q2 = new Question(" kajal rides his scooter 14km at an average speed of 16 km/hr and again travels 16km at an average speed of 14 km/hr. What is her average speed for the entire trip approximately? ", "13.26 km/hr", "10.37 km/hr", " 14.86 km/hr ", " 14.86 km/hr ");
        this.addQuestionfour(q2);
        Question q3 = new Question(" A bus can travel 25% faster than a jeep. Both start from point P at the same time and reach point Q, 225 kms away from P, at the same time. On the way, however, the bus lost about 37.5 minutes while stopping at the certain place. What is the speed of the jeep? ", " 72 km/hr ", "64 km/hr", " 36 km/hr ", " 72 km/hr ");
        this.addQuestionfour(q3);
        Question q4 = new Question(" A race course is 250 m long. P and Q run a race and P wins by 4m. Q and R run over the same course and Q win by 3m. R and S run over it and S wins by 12m. If P and S run over it, then who would win and by how much? ", " S by 5.30m ", " P by 4.82m ", " Q by 6.54m ", " S by 5.30m ");
        this.addQuestionfour(q4);
        Question q5 = new Question(" Kishore is travelling on his bike and has calculated to reach point P at 4 pm if he travels at 20 kmph. He will reach there at 12 noon if he travels at 30 kmph. At what speed must he travel to reach P at 2 pm? ", "34 kmph ", "24 kmph ", "44 kmph ", "24 kmph ");
        this.addQuestionfour(q5);
        Question q6 = new Question(" The speed of a van increases by 5 kmph after every one hour. If the distance travelled in the first one hour was 55 km, what was the total distance travelled in 8 hours? ", " 580km ", " 660km ", " 700km ", " 580km ");
        this.addQuestionfour(q6);
        Question q7 = new Question(" The distance between salem and trichy is 170 km. A bus starts from salem at 6 a.m. and travels towards  trichy at 20 km/hr. Another bus starts from trichy  at 7 a.m. and travels towards salem at 30  km/hr. At what time will they meet? ", " 10a.m ", "11a.m", "8a.m", " 10a.m ");
        this.addQuestionfour(q7);
        Question q8 = new Question(" Tharun has to cover a distance of 84 km in 40 minutes. If he covers one-half of the distance in one-fourth of the total time, to cover the remaining distance in the remaining time, what should be his speed in km/hr? ", " 84km/hr ", " 24km/hr ", " 34km/hr ", " 84km/hr ");
        this.addQuestionfour(q8);
        Question q9 = new Question(" In a 2700 m race around a round track of length 300m, abi and kabi meet at the end of the 3rd  minute, for the first time after the start of the race. All the runners maintain uniform speed throughout the race. If abi runs at twice the speed of the kabi. Find the time taken by abi to finish the race. ", " 27 mints ", " 17 mints ", " 7 mints ", " 27 mints ");
        this.addQuestionfour(q9);
        Question q10 = new Question(" Three friends X, Y and Z run a running race, Y finished 12 meters ahead of Z and 18 m ahead of X, while Z finished 8m ahead of X. If each friends runs the entire distance at their respective constant speeds, what is the length of the race? ", " 48m ", " 32m ", " 28m ", " 48m ");
        this.addQuestionfour(q10);
        Question q11 = new Question(" A car covers a distance of 1120 metres in 1 minute whereas a bus covers a distance of 56 kms in 44 minutes. What is the ratio of their speed?", " 22:25 ", " 11:15 ", " 25:22 ", " 22:25 ");
        this.addQuestionfour(q11);

        Question q12 = new Question(" Anushiya covered a definite distance at some speed. If she had moved 5 kmph faster, she would have taken 55minutes less. If he had moved 4 kmph slower, she would have taken 55 minutes more. What is the distance in km? ", " 440 km ", " 330km ", " 110 km ", " 330km ");

    }

    private void loadQuestionsfive() {
        Question q1 = new Question("If in a certain language, MADRAS is coded as NBESBT, how is BOMBAY coded in that code?", " CPNCBZ ", "CPOCBZ", "None", " CPNCBZ ");
        this.addQuestionfive(q1);
        Question q2 = new Question("In a certain code, TRIPPLE is written as SQHOOKD. How is DISPOSE written in that code ?", "None", " CHRONRD ", " ESJTPTF ", " CHRONRD ");
        this.addQuestionfive(q2);
        Question q3 = new Question("If in a code language. COULD is written as BNTKC and MARGIN is written as LZQFHM, how will MOULDING be written in that code ?", " LNTKCHNE", " LNTLCHMF ", " LNTKCHMF ", " LNTKCHMF ");
        this.addQuestionfive(q3);
        Question q4 = new Question("In a certain code, MONKEY is written as XDJMNL. How is TIGER written in that code ?", "QDFHS", "QBFHS", "QDTED", "QDFHS");
        this.addQuestionfive(q4);
        Question q5 = new Question("If FRAGRANCE is written as SBHSBODFG, how can IMPOSING be written ?", " SDFHS ", "None", " NQPTJOHJ ", " NQPTJOHJ ");
        this.addQuestionfive(q5);
        Question q6 = new Question("In a certain code, COMPUTER is written as RFUVQNPC. How is MEDICINE written in the same code ?", " EOJDJEFM ", " MFEJDJOE ", " MFEDJJOE ", " EOJDJEFM ");
        this.addQuestionfive(q6);
        Question q7 = new Question("If in a certain language. GAMBLE is coded as FBLCKF, how is FLOWER coded in that code ?", "GMPVDS", "BMPVDS", " EMNXDS ", " EMNXDS ");
        this.addQuestionfive(q7);
        Question q8 = new Question("If in a certain language, NATURE is coded as MASUQE, how is FAMINE coded in that code ?", " EALIME ", " FZMHND ", " FZMHYF ", " EALIME ");
        this.addQuestionfive(q8);
        Question q9 = new Question("If in a certain code. TEACHER is written as VGCEJGT, how would DULLARD be written in the same code ? ", " FWNNCSF ", " FWNNCTF ", " FWNNCBT", " FWNNCTF ");
        this.addQuestionfive(q9);
        Question q10 = new Question("If in a certain language FASHION is coded as FOIHSAN. how is PROBLEM coded in that code ? ", " RPBOELM ", " RPBOELL", " PELBORM ", " PELBORM ");
        this.addQuestionfive(q10);
        Question q11 = new Question(" If in a certain language KINDLE is coded as ELDNIK, how is EXOTIC coded in that code ? ", " CITOXE ", " COXITE ", "None", " CITOXE ");
        this.addQuestionfive(q11);

    }

    private void loadQuestionssix() {
        Question q1 = new Question("Pointing to a man on the stage, Rita said, He is the brother of the daughter of the wife of my husband. How is the man on the stage related to Rita ? ", " Son ", " Husband", "Father", " Son ");
        this.addQuestionsix(q1);
        Question q2 = new Question("Showing the man receiving the prize, Saroj said, MHe is the brother of my uncle's daughter. Who is the man to Saroj ? ", " Cousin ", " Uncle ", "Brother-in-law ", " Cousin ");
        this.addQuestionsix(q2);
        Question q3 = new Question("Pointing to a man, a woman said, His mother is the only daughter of my mother. How is the woman related to the man ?", " Mother ", "Grandmother", "None", " Mother ");
        this.addQuestionsix(q3);
        Question q4 = new Question("Pointing to a photograph, a person tells his friend, She is the grand daughter of the elder brother of my father' How is the girl in the photograph related to his fhan ? ", "Sister", "Niece", "Mother", "Niece");
        this.addQuestionsix(q4);
        Question q5 = new Question("Pointing to a photograph, Vipul saidr She is the daughter of my grandfather's onfy son.How is Vipul related to the girl in the photograph ?", "Brother", " Data inadequate ", "Father", "Brother");
        this.addQuestionsix(q5);
        Question q6 = new Question("A woman introduces a man as the son of the brother of her mother. How is the man. related to the woman ? ", " Cousin ", "Father", "Mother", " Cousin ");
        this.addQuestionsix(q6);
        Question q7 = new Question("Looking at a portrait of a man, Harsh said, His mother is the wife of my father's son. Brothers and sisters I have none. At whose portrait was Harsh looking ?", " His father", " His son ", " His brother", " His son ");
        this.addQuestionsix(q7);
        Question q8 = new Question("A man said to a lady, Your mother's husband's sister is my aunt.? How is the lady related to the man ? ", "Aunt", "Uncle", " Sister ", " Sister ");
        this.addQuestionsix(q8);
        Question q9 = new Question("If Neena says, Anita's father Raman is the only son of my father-in-law MahipaT, then how is Bindu, who is the sister of Anita, related to Mahipal ? ", "Daughter", "Son", " None ", " None ");
        this.addQuestionsix(q9);
        Question q10 = new Question("Pointing to a girl in the photograph, Amar said, Her mother's brother is the only son of my mother's father. How is the girl's mother related to Amar ? ", "Grandmother", " Aunt ", "Mother", " Aunt ");
        this.addQuestionsix(q10);
        Question q11 = new Question("A girl introduced a boy as the son of the daughter of the father of her uncle. The hpy is girl's ", "Son", " Brother ", "Grandfather", " Brother ");
        this.addQuestionsix(q11);

    }



    private void loadQuestionsseven() {
        Question q1 = new Question("January 1, 2008 is Tuesday. What day of the week lies on Jan. 1, 2009? ", " Thursday ", " Wednesday ", "None", " Thursday ");
        this.addQuestionseven(q1);
        Question q2 = new Question("The calendar for the year 2007 will be the same for the year : ", " 2018 ", " 2008 ", " 2010", " 2018 ");
        this.addQuestionseven(q2);
        Question q3 = new Question("The last day of a century cannot be ", "Monday", " Tuesday ", "Thursday", " Tuesday ");
        this.addQuestionseven(q3);
        Question q4 = new Question("What was the day of the week on 4th June, 2002? ", "None", "Monday", " Tuesday ", " Tuesday ");
        this.addQuestionseven(q4);
        Question q5 = new Question("What was the day of the week on 28th May 2006?", "Sunday", "Monday", "None", "Sunday");
        this.addQuestionseven(q5);
        Question q6 = new Question("What was the day of the week on 17th June 1998? ", "Saturday", " Wednesday ", "Sunday", " Wednesday ");
        this.addQuestionseven(q6);
        Question q7 = new Question("On 8th Dec. 2007 Saturday falls. What day of the week was it on 8 Dec. 2006? ", " Friday ", "Sunday", "Monday", " Friday ");
        this.addQuestionseven(q7);
        Question q8 = new Question("On 6th March 2005 Monday falls. What was the day of the week on 6th March 2004? ", "Monday", " Saturday ", "Sunday", " Saturday ");
        this.addQuestionseven(q8);
        Question q9 = new Question("It was Sunday on Jan. 1, 2006. What was the day of the week on Jan. 1, 2010? ", "Monday", "None", " Friday ", " Friday ");
        this.addQuestionseven(q9);
        Question q10 = new Question(" Today is Monday. After 61 days it will be ", "Saturday", "None", "Sunday", "Saturday");
        this.addQuestionseven(q10);
        Question q11 = new Question(" On 8th Feb. 2005 it was Tuesday. What was the day of the week on 08th Feb. 2004?", "Tuesday", " Sunday ", "Thursday", " Sunday ");
        this.addQuestionseven(q11);

    }

    private void loadQuestionseight() {
        Question q1 = new Question("An accurate clock shows 8 o’clock in the morning. Through how many degrees will the hour hand rotate when the clock shows 2 o’clock in the afternoon? ", " 360° ", " 90° ", " 180° ", " 180° ");
        this.addQuestioneight(q1);
        Question q2 = new Question("The angle between the minute hand and the hour hand of a clock when the time is 4.20, is", " 60° ", " 10° ", " 80° ", " 10° ");
        this.addQuestioneight(q2);
        Question q3 = new Question("How many times in a day, are the hands of a clock in straight line but opposite in direction? ", " 22 ", " 33 ", "None", " 22 ");
        this.addQuestioneight(q3);
        Question q4 = new Question("At 3.40, the hour hand and the minute hand of a clock form an angle of : ", " 100° ", " 180° ", " 130°  ", " 130° ");
        this.addQuestioneight(q4);
        Question q5 = new Question(" At what time, in minutes, between 3 o’clock and 4 o’clock, both the needles will coincide each other? ", "12 3/11", "16 4/11", "None", "16 4/11");
        this.addQuestioneight(q5);
        Question q6 = new Question(" The angle between the minute hand and the hour hand of a clock when the time is 8.30, is : ", " 25° ", " 35° ", " 75° ", " 75° ");
        this.addQuestioneight(q6);
        Question q7 = new Question(" At what time between 9 and 10 o’clock will the hands of a watch be together? ", "49 1/11min past9", "None", "25 1/11min past9", "49 1/11min past9");
        this.addQuestioneight(q7);
        Question q8 = new Question(" At what angle the hands of a clock are inclined at 15 minutes past 5? ", "67 1/2° ", "87 1/2°", "None", "67 1/2°");
        this.addQuestioneight(q8);
        Question q9 = new Question(" At what time between 4 and 5 o’clock will the hands of a watch point in opposite directions? ", " 44 5/11 min. past 4 ", " 54 6/11 min past 4 ", "Data not proper", " 54 6/11 min past 4 ");
        this.addQuestioneight(q9);
        Question q10 = new Question(" How many times do the hands of a clock coincide in a day?", " 44 ", " 55", " 24 ", " 24 ");
        this.addQuestioneight(q10);
        Question q11 = new Question(" The reflex angle between the hands of a clock at 10.25 is : ", "187 1/2°", "None", " 197 1/2°", "197 1/2°");
        this.addQuestioneight(q11);


    }


    private void loadQuestionsnine() {
        Question q1 = new Question("MODULE NINE of class IX there are 130 students 20 % students failed. How many students passed to class\n" +
                "X?", "105", "112", "104", "104");
        this.addQuestionnine(q1);
        Question q2 = new Question("Sanjay gets 72 % marks in examinations. If these are 864 marks, find the maximum marks", "1050", "860", "1200", "1200");
        this.addQuestionnine(q2);
        Question q3 = new Question("In a college of 1335 students, 60 % are boys. Find the number of girls and number of boys in the college?", "924,221", "691,404", "802,333", "691,404");
        this.addQuestionnine(q3);
        Question q4 = new Question("A foot ball team lost 75 % of the matches it played. If it won 45 matches, find the number of matches it played.", "120", "180", "145", "180");
        this.addQuestionnine(q4);
        Question q5 = new Question("Brother's weight is 25 % more than that of sister. What percent is brother’s weight less than sister's weight?", "25%", "20%", "30%", "20%");
        this.addQuestionnine(q5);
        Question q6 = new Question("mouli had $ 3600 left after spending 40 % of the money he took for shopping. How much money did he\n" +
                "take along with him?", "2500", "6000", "4500", "6000");
        this.addQuestionnine(q6);
        Question q7 = new Question("Mithun went to a shop and bought things worth Rs. 75, out of which 90 Paise went on sales tax on taxable\n" +
                "purchases. If the tax rate was 18%, then what was the cost of the tax free items?", "69.1", "34.5", "12.5", "69.1");
        this.addQuestionnine(q7);
        Question q8 = new Question("Gowthaman needs 25% to pass. If he scored 424 marks and falls short by 26 marks, what was the\n" +
                "maximum marks he could have got?", "2725", "2650", "1800", "1800");
        this.addQuestionnine(q8);
        Question q9 = new Question(" In an exam Aashika secured 1328 marks. If she secured 32 % marks, find the maximum marks.", "1298", "4150", "4400", "4150");
        this.addQuestionnine(q9);
        Question q10 = new Question("A number is increased by 70 % and then decreased by 70 %. Find the net increase or decrease per cent.", "45", "25", "56", "45");
        this.addQuestionnine(q10);
        Question q11 = new Question("Find the length of a string by which a goat must be tethered in order that it may be able to graze an area of 3426 sq. metres.", "33.01", "26.7", "37.2", "33.01");
        this.addQuestionnine(q11);
    }


    private void loadQuestionsten() {
        Question q1 = new Question(" The smallest number which when diminished by 7, is divisible by 12, 16, 18, 21 and 28 is ", "1015", "990", "875", "1015");
        this.addQuestionnine(q1);
        Question q2 = new Question("The HCF of two numbers is 11 and their LCM is 7700. If one of the numbers is 275, then the other is ", "308", "420", "456", "308");
        this.addQuestionnine(q2);
        Question q3 = new Question("The product of two numbers is 4107. If the HCF of those numbers is 37, then the greater number is ", "111", "211", "311", "111");
        this.addQuestionnine(q3);
        Question q4 = new Question("The greatest possible length which can be used to measure exactly the length 7m, 3m, 85cm, 12m, 95 cm is ", "35", "37", "27", "35");
        this.addQuestionnine(q4);
        Question q5 = new Question("Find the greatest number that will divide 43, 91 and 183 so as to leave the same remained in each case", "4", "12", "14", "4");
        this.addQuestionnine(q5);
        Question q6 = new Question("The G.C.D. of 1.08, 0.36 and 0.9 is ", "-0.18", "-0.28", "-0.35", "-0.18");
        this.addQuestionnine(q6);
        Question q7 = new Question("Three numbers are in the ration 1 : 2 : 3 and their HCF is 12. The numbers are ", "12,24.36", "18,24.36", "12,27.36", "12,24.36");
        this.addQuestionnine(q7);
        Question q8 = new Question("A rectangular courty 3.78 metres long and 5.25 metres wide is to be paved exactly with square tiles, all of the same size. What is the largest size of the tile which could be used for the purpose? ", "21", "23", "28", "21");
        this.addQuestionnine(q8);
        Question q9 = new Question("The product of two numbers is 1320 and their HCF is 6. The LCM of the numbers is ", "220", "326", "320", "220");
        this.addQuestionnine(q9);
        Question q10 = new Question(" Product of two co-prime numbers is 117. Their LCM should be ", "117", "135", "128", "117");
        this.addQuestionnine(q10);
        Question q11 = new Question(" The maximum numbers of students among them 1001 pens and 910 pencils can be distributed in such a way that each student gets the same number of pens and same number of pencils is ", "91", "89", "79", "91");
        this.addQuestionnine(q11);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTTWO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTTHREE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTFOUR);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTFIVE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTSIX);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTSEVEN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTEIGHT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTNINE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTTEN);
        onCreate(db);
    }

    public void addQuestion(Question quest) {
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        sqLiteDatabase.insert(TABLE_QUEST, null, values);
    }

    public void addQuestiontwo(Question quest) {
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        sqLiteDatabase.insert(TABLE_QUESTTWO, null, values);
    }

    public void addQuestionthree(Question quest) {
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        sqLiteDatabase.insert(TABLE_QUESTTHREE, null, values);
    }
    public void addQuestionfour(Question quest) {
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        sqLiteDatabase.insert(TABLE_QUESTFOUR, null, values);
    }
    public void addQuestionfive(Question quest) {
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        sqLiteDatabase.insert(TABLE_QUESTFIVE, null, values);
    }
    public void addQuestionsix(Question quest) {
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        sqLiteDatabase.insert(TABLE_QUESTSIX, null, values);
    }
    public void addQuestionseven(Question quest) {
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        sqLiteDatabase.insert(TABLE_QUESTSEVEN, null, values);
    }
    public void addQuestioneight(Question quest) {
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        sqLiteDatabase.insert(TABLE_QUESTEIGHT, null, values);
    }
    public void addQuestionnine(Question quest) {
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        sqLiteDatabase.insert(TABLE_QUESTNINE, null, values);
    }
    public void addQuestionten(Question quest) {
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        sqLiteDatabase.insert(TABLE_QUESTTEN, null, values);
    }

    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        String selectQuery = "SELECT * FROM " + TABLE_QUEST;
        sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        return quesList;
    }

    public List<Question> getAllQuestionstwo() {
        List<Question> quesList = new ArrayList<Question>();
        String selectQuery = "SELECT * FROM " + TABLE_QUESTTWO;
        sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        return quesList;
    }
    public List<Question> getAllQuestionsthree() {
        List<Question> quesList = new ArrayList<Question>();
        String selectQuery = "SELECT * FROM " + TABLE_QUESTTHREE;
        sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        return quesList;
    }
    public List<Question> getAllQuestionsfour() {
        List<Question> quesList = new ArrayList<Question>();
        String selectQuery = "SELECT * FROM " + TABLE_QUESTFOUR;
        sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        return quesList;
    }
    public List<Question> getAllQuestionsfive() {
        List<Question> quesList = new ArrayList<Question>();
        String selectQuery = "SELECT * FROM " + TABLE_QUESTFIVE;
        sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        return quesList;
    }
    public List<Question> getAllQuestionssix() {
        List<Question> quesList = new ArrayList<Question>();
        String selectQuery = "SELECT * FROM " + TABLE_QUESTSIX;
        sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        return quesList;
    }
    public List<Question> getAllQuestionsseven() {
        List<Question> quesList = new ArrayList<Question>();
        String selectQuery = "SELECT * FROM " + TABLE_QUESTSEVEN;
        sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        return quesList;
    }
    public List<Question> getAllQuestionseight() {
        List<Question> quesList = new ArrayList<Question>();
        String selectQuery = "SELECT * FROM " + TABLE_QUESTEIGHT;
        sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        return quesList;
    }
    public List<Question> getAllQuestionsnine() {
        List<Question> quesList = new ArrayList<Question>();
        String selectQuery = "SELECT * FROM " + TABLE_QUESTNINE;
        sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        return quesList;
    }
    public List<Question> getAllQuestionsten() {
        List<Question> quesList = new ArrayList<Question>();
        String selectQuery = "SELECT * FROM " + TABLE_QUESTTEN;
        sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        return quesList;
    }


    public List<PointofContactObj> getPointofContactDetails(){
        List<PointofContactObj> list = new ArrayList<>();

        PointofContactObj contact1 = new PointofContactObj();
        contact1.setEmpID("E12325");
        contact1.setEmpName("Ramesh");

        PointofContactObj contact2 = new PointofContactObj();
        contact2.setEmpID("E12321");
        contact2.setEmpName("Ganesh");

        PointofContactObj contact3 = new PointofContactObj();
        contact3.setEmpID("E13245");
        contact3.setEmpName("Manoj");

        list.add(contact1);
        list.add(contact2);
        list.add(contact3);

        return list;
    }


    public void insertCandidateDetails(CandidateObj candidateObj) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_C_CODE, candidateObj.getCode());
        values.put(COLUMN_C_NAME, candidateObj.getName());
        values.put(COLUMN_C_EMAIL, candidateObj.getEmail());
        values.put(COLUMN_C_NUMBER, candidateObj.getNumber());
        values.put(COLUMN_C_TECHNOLOGY, candidateObj.getTechnology());
        values.put(COLUMN_C_EMP_ID, candidateObj.getPoc());
        values.put(COLUMN_C_EMP_NAME, candidateObj.getEmpName());

        try {
            sqLiteDatabase.insert(TABLE_CANDIDATE, null, values);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            sqLiteDatabase.close();
        }
    }


    public void insertEmployeeDetails(EmployeeObj employeeObj) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_EMP_ID, employeeObj.getEmpID());
        values.put(COLUMN_EMP_NAME, employeeObj.getName());
        values.put(COLUMN_EMP_DESIGNATION, employeeObj.getDesignation());
        sqLiteDatabase = this.getReadableDatabase();
        try {
            sqLiteDatabase.insert(TABLE_EMPLOYEE, null, values);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public CandidateObj getCandidateInformation(String cCode){
        CandidateObj candidateObj = new CandidateObj();
        sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(SELECT_CANDIDATE_QUERY, new String[]{cCode});
        if (cursor.getCount() > 0 && cursor.moveToFirst()) {
            do {
                candidateObj.setCode(cursor.getString(cursor.getColumnIndex(COLUMN_C_CODE)));
                candidateObj.setName(cursor.getString(cursor.getColumnIndex(COLUMN_C_NAME)));
                candidateObj.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_C_EMAIL)));
                candidateObj.setNumber(cursor.getString(cursor.getColumnIndex(COLUMN_C_NUMBER)));
                candidateObj.setTechnology(cursor.getString(cursor.getColumnIndex(COLUMN_C_TECHNOLOGY)));
                candidateObj.setPoc(cursor.getString(cursor.getColumnIndex(COLUMN_C_EMP_ID)));
                candidateObj.setEmpName(cursor.getString(cursor.getColumnIndex(COLUMN_C_EMP_NAME)));

            } while (cursor.moveToNext());
        }
        return candidateObj;
    }


    public boolean isValidCandidate(String cCode){
        sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(SELECT_CANDIDATE_QUERY, new String[]{cCode});
        if (cursor.getCount() > 0 && cursor.moveToFirst()) {
            return cursor.getCount()>0;
        }
        return false;
    }

    public boolean isValidEmployee(String code){
        sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(SELECT_EMP_QUERY, new String[]{code});
        if (cursor.getCount() > 0 && cursor.moveToFirst()) {
            return cursor.getCount()>0;
        }
        return false;
    }


    public List<EmployeeObj> getAllEmployees(){

        List<EmployeeObj> list = new ArrayList<>();
        sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(SELECT_ALL_EMP_QUERY, null);
        if (cursor.getCount() > 0 && cursor.moveToFirst()) {
            do {
                EmployeeObj empObj = new EmployeeObj();
                empObj.setEmpID(cursor.getString(cursor.getColumnIndex(COLUMN_EMP_ID)));
                empObj.setName(cursor.getString(cursor.getColumnIndex(COLUMN_EMP_NAME)));
                empObj.setDesignation(cursor.getString(cursor.getColumnIndex(COLUMN_EMP_DESIGNATION)));
                list.add(empObj);

            } while (cursor.moveToNext());
        }
        return list;
    }


    public List<CandidateObj> getCandidateListByEmployee(String empCode) {
        List<CandidateObj> list = new ArrayList<>();
        sqLiteDatabase = this.getReadableDatabase();
        //Cursor cursor =  sqLiteDatabase.query(TABLE_CANDIDATE,null,null,null,null,null,null);
        Cursor cursor = sqLiteDatabase.rawQuery(SELECT_CANDIDATE_BY_EMP_CODE_QUERY, new String[]{empCode});
        if (cursor.getCount() > 0 && cursor.moveToFirst()) {
            do {
                CandidateObj empObj = new CandidateObj();
                empObj.setPoc(cursor.getString(cursor.getColumnIndex(COLUMN_EMP_ID)));
                empObj.setName(cursor.getString(cursor.getColumnIndex(COLUMN_C_NAME)));
                empObj.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_C_EMAIL)));
                empObj.setNumber(cursor.getString(cursor.getColumnIndex(COLUMN_C_NUMBER)));
                empObj.setResult(cursor.getString(cursor.getColumnIndex(COLUMN_C_RESULT)));
                list.add(empObj);

            } while (cursor.moveToNext());
        }
        return list;
    }

    public void updateResult(String resultStatus, String mCCOde) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_C_RESULT, resultStatus);
        sqLiteDatabase = this.getReadableDatabase();
        try {
            sqLiteDatabase.update(TABLE_CANDIDATE, values,"c_code=?", new String[]{mCCOde});
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}