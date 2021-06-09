package robots;

import ClothesDecoration.*;
import Decorator.*;
import HairDecoration.*;
import Pets.Pet;

import java.io.*;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Manager extends robot {
    static Scanner sc = new Scanner(System.in);
    static int petCount = 0;
    static int moneyCount = 0;

    public static void printMenu() {
        System.out.println("What can I help you ?");
        System.out.println("0.赛博朋克退出系统");
        System.out.println("1.赛博朋克宠物寄存");
        System.out.println("2.赛博朋克理发店");
        System.out.println("3.赛博朋克裁缝店\n");
    }

    public static void printBarberMenu() {
        System.out.println("What can I help you?");
        System.out.println("任意服务享受免费吹");
        System.out.println("1.洗澡");
        System.out.println("2.剪毛");
        System.out.println("3.烫毛");
        System.out.println("0.退出");
    }

    public static void barberMain(Pet pet) {
        HairDecoration hairDecoration = new Chui();
        ArrayList<String> hairList = new ArrayList<>();
        hairList.add("Chui");
        boolean sign = false;
        while (true) {
            printBarberMenu();
            int flag;
            try {
                flag = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("请输入一个数字");
                sc.next();
                continue;
            }
            if (flag <= 0)
                break;
            else if (flag > 3)
                System.out.println("请输入正确的数字");
            else {
                if (flag == 1) {
                    hairDecoration = new Wash(hairDecoration);
                    hairList.add("Wash");
                    sign = true;
                } else if (flag == 2) {
                    hairDecoration = new Cut(hairDecoration);
                    hairList.add("Cut");
                    sign = true;
                } else {
                    hairDecoration = new Tang(hairDecoration);
                    hairList.add("Tang");
                    sign = true;
                }
            }


        }
        moneyCount += hairDecoration.costSum();
        if (sign) {
            new Thread(new Barber(pet, hairDecoration, hairList)).start();
        }

    }

    public static void printEditorMenu1() {
        System.out.println("请选择服装款式");
        System.out.println("1.衣服");
        System.out.println("2.裤子");
        System.out.println("3.帽子");
        System.out.println("4.鞋子");
        System.out.println("0.退出");
    }

    public static void printEditorMenu2() {
        System.out.println("请选择颜色");
        System.out.println("1.湖底蓝");
        System.out.println("2.炽热红");
        System.out.println("3.活力橙");
        System.out.println("4.高冷灰");
        System.out.println("0.普通色");
    }

    public static void printEditorMenu3() {
        System.out.println("请选择材质");
        System.out.println("1.透气棉");
        System.out.println("2.奢华皮");
        System.out.println("3.清爽麻");
        System.out.println("0.普通材质");
    }

    public static void editorMain(Pet pet) {
        Clothes clothes;
        boolean sign = false;
        ArrayList<String> editList = new ArrayList<>();
        while (true) {
            printEditorMenu1();
            int flag;
            try {
                flag = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("请输入一个数字");
                sc.next();
                continue;
            }
            if (flag == 0)
                return;
            else if (flag < 0 | flag > 4) {
                System.out.println("请正确输入指令！");
            } else {
                if (flag == 1) {
                    clothes = new Shirt();
                    editList.add("Shirt");
                } else if (flag == 2) {
                    clothes = new Trousers();
                    editList.add("Trousers");
                } else if (flag == 3) {
                    clothes = new Hat();
                    editList.add("Hat");
                } else {
                    clothes = new Shoe();
                    editList.add("Shoe");
                }
                break;
            }

        }

        while (true) {
            printEditorMenu2();
            int flag;
            flag = sc.nextInt();
            if (flag == 0)
                break;
            else if (flag < 0 | flag > 4) {
                System.out.println("请正确输入指令！");
            } else {
                if (flag == 1) {
                    clothes = new Blue(clothes);
                    editList.add("Blue");
                } else if (flag == 2) {
                    clothes = new Red(clothes);
                    editList.add("Red");
                } else if (flag == 3) {
                    clothes = new Orange(clothes);
                    editList.add("Orange");
                } else {
                    clothes = new Gray(clothes);
                    editList.add("Gray");
                }
                break;
            }

        }

        while (true) {
            printEditorMenu3();
            int flag;
            flag = sc.nextInt();
            if (flag == 0)
                break;
            else if (flag < 0 || flag > 3) {
                System.out.println("请正确输入指令！");
            } else {
                if (flag == 1) {
                    clothes = new Cotton(clothes);
                    editList.add("Cotton");
                } else if (flag == 2) {
                    clothes = new Fur(clothes);
                    editList.add("Fur");
                } else {
                    clothes = new Flax(clothes);
                    editList.add("Flax");
                }
                break;
            }

        }

        new Thread(new Editor(pet, (ClothesDecoration) clothes, editList)).start();
        moneyCount += clothes.costSum();

    }

    public synchronized static void managerReport(int petNUm, int money) {
        try {
            FileReader fr = new FileReader("log.txt");
            BufferedReader br = new BufferedReader(fr);
            String buf;
            while ((buf = br.readLine()) != null)
                System.out.println(buf);
            System.out.println("总共领养宠物个数：" + petNUm);
            System.out.println("总共收入：" + money);
        } catch (IOException e) {
            System.out.println("汇报失败！");
        }
    }

    public static void main(String[] args) {
        String name;
        String kind;
        while (true) {
            System.out.println("欢迎来到赛博朋克宠物店\n0.退出\n1.继续\n2.汇报（需要密码）");
            int flag;
            try {
                flag = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("请输入一个数字");
                sc.next();
                continue;
            }
            if (flag == 0)
                return;
            else if (flag == 2) {
                System.out.println("请输入密码（提示：fuxiao）：");
                String password = sc.next();
                if (password.equals("fuxiao")) {
                    managerReport(petCount, moneyCount);
                } else {
                    System.out.println("密码错误!");
                }
            } else {
                System.out.println("请输入宠物姓名");
                name = sc.next();
                System.out.println("请输入宠物种类");
                kind = sc.next();
                Pet pet = new Pet(name, kind);
                boolean f = true;
                while (f) {
                    printMenu();
                    int sign;
                    try {
                        sign = sc.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("请输入一个数字");
                        sc.next();
                        continue;
                    }
                    switch (sign) {
                        case 1:
                            System.out.println("请输入寄养时间(小时)>=24");
                            int time = sc.nextInt();
                            System.out.println("请输入喂养间隔（小时）");
                            int feedTime = sc.nextInt();
                            if (time <= 24) {
                                System.out.println("时间过短不允许寄存！");
                                break;
                            }
                            new Thread(new Keeper(pet, new Feeder(pet, feedTime), time, feedTime)).start();
                            System.out.println("寄存成功！");
                            petCount++;
                            moneyCount += 10 * time;
                            break;
                        case 2:
                            barberMain(pet);
                            System.out.println("理发服务已经开始进行！");
                            break;
                        case 3:
                            editorMain(pet);
                            System.out.println("服装服务已经开始进行！");
                            break;
                        case 0:
                            f = false;
                            break;
                        default:
                            System.out.println("请输入正确数字!");
                    }
                }
            }

        }

    }
}

class robot {
    protected FileLock fl;
    protected OutputStreamWriter osw;
    protected BufferedWriter bw;
    protected FileOutputStream fos;
}

class workingRobot extends robot {
    Pet pet;
}

class Keeper extends workingRobot implements Runnable {
    Feeder feeder;
    int time;
    int feedTime;

    public Keeper(Pet pet, Feeder feeder, int time, int feedTime) {
        this.pet = pet;
        this.feeder = feeder;
        this.time = time;
        this.feedTime = feedTime;
    }

    private synchronized void report1() {
        try {

            fos = new FileOutputStream("log.txt", true);
            osw = new OutputStreamWriter(fos);
            bw = new BufferedWriter(osw);
            fl = fos.getChannel().lock();
            if (fl != null) {
                bw.write(new Date() + " Keeper " + pet.name + " 寄养成功 " + pet + "\n");
                bw.flush();
                fl.release();
                bw.close();
                bw.close();
            }
        } catch (IOException e) {
            System.out.println("Logging failed");
        }

    }

    private synchronized void report2() {
        try {

            fos = new FileOutputStream("log.txt", true);
            osw = new OutputStreamWriter(fos);
            bw = new BufferedWriter(osw);
            fl = fos.getChannel().lock();
            if (fl != null) {
                bw.write(new Date() + " Keeper " + pet.name + " 领养成功 " + pet + "\n");
                bw.flush();
                fl.release();
                bw.close();
                bw.close();
            }
        } catch (IOException e) {
            System.out.println("Logging failed");
        }

    }

    private synchronized void report3() {
        try {

            fos = new FileOutputStream("log.txt", true);
            osw = new OutputStreamWriter(fos);
            bw = new BufferedWriter(osw);
            fl = fos.getChannel().lock();
            if (fl != null) {
                bw.write(new Date() + " Keeper " + pet.name + " 主人提前强行领养 " + pet + "\n");
                bw.flush();
                fl.release();
                bw.close();
                bw.close();
            }
        } catch (IOException e) {
            System.out.println("Logging failed");
        }

    }

    public void run() {

        try {
            report1();
            Thread feederThread = new Thread(new Feeder(pet, feedTime));
            feederThread.start();
            Thread.sleep(time * 1000L);
            while (true) {
                boolean sign = feederThread.isAlive();
                if (!sign)
                    break;
                else
                    feederThread.interrupt();
            }

            report2();
        } catch (InterruptedException e) {
            report3();
        }
    }
}

class Feeder extends workingRobot implements Runnable {
    int feedTime;

    public Feeder(Pet pet, int feedTime) {
        this.pet = pet;
        this.feedTime = feedTime;
    }

    private void report() {
        try {
            fos = new FileOutputStream("log.txt", true);
            osw = new OutputStreamWriter(fos);
            bw = new BufferedWriter(osw);
            fl = fos.getChannel().lock();
            if (fl != null) {
                bw.write(new Date() + " Feeder " + pet.name + " 喂养成功 " + pet.kind + " food -1 " + pet + "\n");
                bw.flush();
                fl.release();
                bw.close();
                bw.close();
            }
        } catch (IOException e) {
            System.out.println("Logging failed!");
        }

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(feedTime * 1000L);
                report();
            } catch (InterruptedException interruptedException) {
                return;
            }
        }
    }
}

class Barber extends workingRobot implements Runnable {
    HairDecoration hairDecoration;
    ArrayList<String> hairList;

    public Barber(Pet pet, HairDecoration hairDecoration, ArrayList<String> hairList) {
        this.pet = pet;
        this.hairDecoration = hairDecoration;
        this.hairList = hairList;
    }

    private void report() {
        try {
            fos = new FileOutputStream("log.txt", true);
            osw = new OutputStreamWriter(fos);
            bw = new BufferedWriter(osw);
            fl = fos.getChannel().lock();
            if (fl != null) {
                bw.write(new Date() + " Barber " + pet.name + " 新发型 : " + hairList + " " + pet + "\n");
                fl.release();
                bw.close();
                bw.close();
            }
        } catch (IOException e) {
            System.out.println("Logging failed!");
        }


    }

    @Override
    public void run() {
        try {
            Thread.sleep(hairDecoration.timeSum());
            pet.hairList.addAll(hairList);
            report();
        } catch (InterruptedException e) {
            System.out.println("Decoration unfinished!");
        }
    }
}

class Editor extends workingRobot implements Runnable {
    ClothesDecoration clothes;
    ArrayList<String> clothList;

    public Editor(Pet pet, ClothesDecoration clothes, ArrayList<String> clothList) {
        this.pet = pet;
        this.clothes = clothes;
        this.clothList = clothList;
    }

    private void report() {
        try {
            fos = new FileOutputStream("log.txt", true);
            osw = new OutputStreamWriter(fos);
            bw = new BufferedWriter(osw);
            fl = fos.getChannel().lock();
            if (fl != null) {
                bw.write(new Date() + " Editor " + pet.name + " 新衣服: " + clothList + " " + pet + "\n");
                bw.flush();
                fl.release();
                bw.close();
                bw.close();
            }
        } catch (IOException e) {
            System.out.println("Logging failed!");
        }


    }

    @Override
    public void run() {
        try {
            Thread.sleep(clothes.timeSum());
            pet.clothesList.addAll(clothList);
            report();
        } catch (InterruptedException e) {
            System.out.println("Dressing up unfinished");
        }
    }
}



