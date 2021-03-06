package com.natallia.radaman.epamlabrecyclerandlistview.Model;

import java.util.ArrayList;
import java.util.List;

public class PlaceList {
    private static PlaceList workInstance = null;

    private List<Place> places;

    private PlaceList() {
        initPlaceList();
    }

    public static PlaceList getWorkInstance() {
        if (workInstance == null) {
            workInstance = new PlaceList();
            return workInstance;
        } else
            return workInstance;
    }

    public List<Place> getPlaces() {
        return places;
    }

    private void initPlaceList() {
        places = new ArrayList<>();
        places.add(new Place("Корфу", "39° 37' северной широты. 19° 55' восточной долготы",
                "http://myvezde.com/wp-content/uploads/2017/12/54271_900-800x600.jpg", 4,
                "Генрих Шлиман, раскопавший Трою, считал," +
                " что Корфу — описанный Гомером в «Одиссее» остров Схерия, куда царь Итаки попал во" +
                " время своих скитаний по пути домой. После сурового шторма, который уничтожил корабль" +
                " Одиссея, волны вынесли героя на берег прекрасного острова. Земля там была плодородна," +
                " люди предприимчивы и богаты, а местный царь Алкиной провел спортивные игры, после победы" +
                " Одиссея на которых одарил героя золотой одеждой и помог собрать корабль для возвращения" +
                " домой. Посейдон, не любивший Одиссея, в наказание превратил судно, доставившее воина" +
                " на родину, в камень таких размеров, что появился целый остров. Этот остров получил" +
                " название Понтиконисси и по форме напоминал жителям Корфу мышь. С той поры каждый," +
                " кто хочет быть таким же отважным и хитроумным, как Одиссей," +
                " должен посетить этот островок."));
        places.add(new Place("Крит", "35.2937508 северной широты. 24.7158051 восточной долготы",
                "http://aviamaniya.ru/wp-content/uploads/2017/05/Krit-dostoprimechatelnosti-samostojatelno-na-mashine-7-400x300.jpg",
                4, "Согласно этому мифу, сын неба и земли" +
                " Кронос был женат на Рее (приходившийся ему родной сестрой). Однажды Кроносу предсказали," +
                " что его настигнет смерть от родного потомка, после чего тот стал пожирать собственных детей." +
                " забеременев Зевсом, Рея убежала на Крит, где и родила будущего царя богов в одной" +
                " из местных пещер. Местные жители также верят, что рождение этого ребенка дало начало" +
                " всей человеческой цивилизации!"));
        places.add(new Place("Кипр", "35°10 северной широты. 33°21 восточной долготы",
                "http://cs.holaplaya.com/uploads/sites/3/2013/05/173687844_597b769a23_b-950x712.jpg",
                4, "На западном побережье Кипра, на заповедном" +
                " полуострове Акамас, в тайном гроте бегут два ручейка. В одном ручейке вода живая," +
                " в другом – вода мертвая. Шутник и озорник Эрос окунает свои стрелы поочередно в один" +
                " и другой ручеек. Если поразит вас стрела, орошенная живой водой, любовь придет к вам" +
                " сладкая и светлая. Если же не повезет, и попадет в вас стрела с капельками мертвой воды," +
                " полюбите вы безответно, печаль пронзит сердце."));
        places.add(new Place("Фуэртевентура", "28.3587436 северной широты. 14.05367 западной долготы",
                "https://www.viajejet.com/wp-content/viajes/costa-calma-fuerteventura-400x300.jpg",
                5, "Однажды Оливина, внучка" +
                " самого старого и мудрого пастуха на острове, посла овец одна, так как её дедушка" +
                " был болен. Когда она возвращалась домой, она поняла, что в стаде не хватает одного" +
                " ягненка и стала осматриваться. Увидев ягненка на самой высокой скале, Оливина пыталась" +
                " спасти его, но он, испугавшись, оступился и упал в пропасть. Девушка так опечалилась," +
                " что села к подножью этой горы и начала безутешно плакать. Волнуясь за внучку," +
                " которая не пришла домой в нужное время, ее дедушка спросил у птиц, что с ней случилось." +
                " Старик был так тронут, когда узнал о произошедшем, что попросил птиц подобрать зеленые" +
                " слезы Оливины и положить их около основания гор, как символ боли и человеческой" +
                " доброты. Именно тогда и появился камень оливин, родившийся из камня и слез, в " +
                "вулканических породах на островов."));
        places.add(new Place("Гран Канария", "28.051 северной широты. 15.2431 западной долготы",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR7zHvsCXHeDz2wsClG5o3CwLIuqDMzOLPWZRaApRO_2PZUGgom",
                4, "Драконовое дерево растет очень" +
                " долго и медленно. Возраст некоторых таких деревьев исчисляется столетиями, а смола" +
                " имеет кроваво-красный цвет, напоминая кровь. Жители Канарских островов верили, что" +
                " это и не дерево вовсе, а заколдованный дракон. По другой легенде, деревья выросли" +
                " на том месте, где Геракл пролил кровь дракона, совершая свои 12 подвигов." +
                " Оказавшись на Канарских островах, обязательно стоит прикоснуться к этому дереву:" +
                " по некоторым преданиям, это приносит удачу и долголетие."));
        places.add(new Place("Ибица", "39.0132 северной широты. 1ю3977 восточной долготы",
                "https://kyero.cloudimg.io/crop/400x300/q82/http://production.kyero.s3.amazonaws.com/5205/5205648/jlw2e4ux4qf_cw-ibiza-14836616411670511.jpg?NO_CHECKSUM&env=production",
                4, "Если вас интересуют места силы и магнитные" +
                " аномалии, то вам непременно нужно побывать на острове Эс-Ведра! Трудно найти более" +
                " загадочное место на планете. Это не без гордости подтвердят вам те, кто уже побывал" +
                " на необитаемом острове и успел убедиться, что с такими местами шутки плохи. " +
                "Расположенный в паре километров от Ибицы остров напоминает своими очертаниями гигантского" +
                " дракона, уходящий в воду \"хвост\" которого представляет собой шлейф застывшей" +
                " вулканической лавы. Кто-то сравнивает его с миражом, кто-то уверяет, что это верхушка" +
                " затонувшей Атлантиды. Залежей железной руды на острове нет, поэтому трудно объяснить" +
                " поведение стрелки компаса, которая на Эс-Ведра буквально сходит с ума. Бытовые приборы" +
                " здесь отказываются работать, поэтому не удивляйтесь, если и ваш мобильный телефон" +
                " вдруг начнет чудить."));
        places.add(new Place("Лансароте", "29.0 северной широты. 13.40 западной " +
                "долготы", "https://kyero.cloudimg.io/crop/400x300/q82/http://production.kyero.s3.amazonaws.com/4999/4999079/61111197_original.jpg?3623670a92d60d4bf1b339378d0def07c9185aad&env=production",
                4, "На Лансароте часто можно" +
                " слышать, что местные жители гуанчи были потомками атлантов. Первые мореплаватели" +
                " встретили на острове высоких и хорошо сложенных, красивых людей. В то время, как" +
                " средний рост европейцев редко превышал 160 см, аборигены Лансароте были гигантами." +
                " Атлантиду, уверяют некоторые ученые, нужно искать именно в Атлантике. Вероятно," +
                " около 12 тысяч лет назад, (что совпадает по датам) упал метеорит и уровень океана" +
                " внезапно поднялся на 50 метров, многие территории оказались под водой, спаслись" +
                " ли атланты на Лансароте неизвестно. Но каких либо артефактов, подтверждающих эту" +
                " теорию найдено не было. Также не было найдено никаких доказательств того, что" +
                " местное население были мореплавателями, разве что плоты, сделанные из пальмовых" +
                " бревен и обшитые шкурами коз. Они скорее всего, использовались для рыбалки." +
                " У гуанчей царил матриархат. Каждая женщина имела по 3-4 мужа, который имел" +
                " свои обязанности - один ловил рыбу, второй пас коз. С каждой новой луной в" +
                " семье происходила ротация и мужья менялись ролями. "));
        places.add(new Place("Мадейра", "40.58508 северной широты. 8.2922 западной " +
                "долготы", "https://keeplook.me/wp-content/uploads/2016/02/1-2.jpg",
                5, "Вернёмся в те  далёкие времена," +
                "  когда происходил  процесс Сотворения Мира, а именно к моменту создания нашей  " +
                "чудесной  Планеты. Творцу так понравилось его создание, что в порыве  самых " +
                "добрых  чувств, взял Он этот шарик в руки и с нежной  отеческой  улыбкой  поцеловал его!" +
                "  Поцелуй пришелся аккурат на те координаты  в Северной Атлантике, где  вследствие" +
                " перечисленных обстоятельств и образовался  остров Мадейра. Поэтому все живущие на Мадейре," +
                " а также прибывающие на остров туристы и путешественники, невольно проникаются" +
                " добродушием, благодушием  и любовью,  как к  восхитительным  местным красотам" +
                "  так и к ближнему. А уж сами островитяне!  Добродушные, доброжелательные," +
                " гостеприимные,  бесхитростные и открытые."));
        places.add(new Place("Майорка", "39.34 северной широты. 2.34 восточной " +
                "долготы", "http://europe2u.ru/wp-content/uploads/2016/03/42e007c53f5a12411e85b54641afc58a-400x300.jpg",
                3, "Один из королей Майорки взял себе в жены " +
                "принцессу из северной части Испании, которая сильно тосковала на этом солнечном острове" +
                " по снегу. Видя ее тоску, любящий супруг приказал высадить множество миндальных" +
                " деревьев, которые в период своего цветения напоминали бы принцессе снег с ее родины." +
                " Вот почему Майорку еще называют миндальным островом."));
        places.add(new Place("Родос", "36.2626 северной широты. 28.1321 восточной долготы",
                "https://s3-eu-west-1.amazonaws.com/uploads.drugiegoroda.ru/3/files/2009/05/rodos-400x300.jpg",
                4, "Издревле было сложено немало историй и легенд," +
                " объясняющих появление острова Родос. Одна легенда гласит, после битвы с титанами" +
                " Зевс решил разделить мир между богами. Однако в этот момент бог Гелиос отсутствовал." +
                " Когда он вернулся, выяснилось, что ему не досталось никакого владения. Гелиос пожаловался" +
                " Зевсу на несправедливость и попросил дать обещание, что та земля, которая появится" +
                " из морской пучины, будет принадлежать ему. И пока Гелиос произносил эти слова, со" +
                " дна моря начал подниматься удивительной красоты остров — Родос. Гелиос, преисполненный" +
                " радости, сделал его самым прекрасным островом Средиземноморья."));
        places.add(new Place("Сардиния", "40.1208 северной широты. 9.0128 западной " +
                "долготы", "http://santorini.co.ua/wp-content/uploads/2015/05/Enchanting_Sea_View_Costa_Smeralda_Resort-400x300.jpg",
                5, "Молодой человек тащил на" +
                " спине своего старого отца умирать и во время этого путешествия жаловался, что отец" +
                " слишком тяжелый и ему трудно его нести. «Отдохни»,- посоветовал ему отец, когда они" +
                " приблизились к большому камню, -«я тоже, когда нес своего отца умирать, остановился" +
                " около этого камня». Но тогда, когда я буду старым, мои дети тоже остановятся у" +
                " этого камня и я закончу свою жизнь так же».\n" +
                "«Конечно, тебя ждет тот же конец».\n" +
                "Молодой человек задумался, почувствовав, как по его спине пробежали мурашки. «Давай," +
                " отец, возврашаемся домой».\n" +
                "С этого дня ни одного старика больше не относили умирать в горы.\n" +
                "Так же жестока была традиция приношения в жертву аристократическими семьями своих " +
                "первых сыновей. Это происходило в Сардинии в пунические времена, детей, достигших" +
                " двеннадцати лет, приносили в жертву богине Танит. Во времена римлян детей стали" +
                " заменять ягнятами."));
        places.add(new Place("Тенерифе", "28.16 северной широты. 16.36 западной " +
                "долготы", "http://www.trn-news.ru/Ru/Upload/Image/The-Canaries-Tenerife-1024x682.jpg",
                5, "История одного из самых" +
                " посещаемых мест Тенерифе берет свое начало еще в древних веках, когда племена" +
                " гуанчи заполняли долины Канарских островов. Эти люди были крайне осторожными:" +
                " держали коз в тени скал и густой растительности, вели сельскохозяйственные работы" +
                " в глубине долин и жили в узких ущельях гигантских скал, которые на сегодняшний день" +
                " стали туристических маршрутами.\n" +
                "Одна из таких пещер – «Адское ущелье» – широко известно своим необыкновенным водопадом," +
                " который начинается в центре города Адехе (Adeje) в конце Калле Молинос (Calle Molinos)," +
                " на высоте около 350 метров над уровнем моря. Свое название это ущелье оправдывает тем," +
                " что добраться до него совсем не просто: для этого нужно пешком преодолеть путь почти" +
                " в семь километров. Обычно, у туристов эта дорога занимает около четырех часов, однако" +
                ", отправляясь в путь, стоит брать с собой достаточное количество воды и еды, и надевать" +
                " прочные ботинки и шлем для защиты головы."));
    }
}
