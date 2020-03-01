package cn.cslg.bus_ZB1018144;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Alice on 2019/12/16.
 */
public class TrainBean implements Serializable {


    /**
     * status : 0
     * msg : ok
     * result : {"start":"杭州","end":"北京","ishigh":"0","date":"2019-12-16","list":[{"trainno":"G34","type":"G","station":"杭州东","endstation":"北京南","departuretime":"06:55","arrivaltime":"13:03","sequenceno":1,"costtime":"6时8分","distance":0,"isend":1,"trainno12306":"5600000G3490","pricesw":1701,"pricetd":1025.5,"pricegr1":null,"pricegr2":null,"pricerw1":null,"pricerw2":null,"priceyw1":null,"priceyw2":null,"priceyw3":null,"typename":"高铁","priceyd":"907.0","priceed":"538.5"},{"trainno":"G58","type":"G","station":"杭州东","endstation":"北京南","departuretime":"08:50","arrivaltime":"14:43","sequenceno":5,"costtime":"5时53分","distance":0,"isend":1,"trainno12306":"5e00000G5840","pricesw":1701,"pricetd":1025.5,"pricegr1":null,"pricegr2":null,"pricerw1":null,"pricerw2":null,"priceyw1":null,"priceyw2":null,"priceyw3":null,"typename":"高铁","priceyd":"907.0","priceed":"538.5"},{"trainno":"G46","type":"G","station":"杭州东","endstation":"北京南","departuretime":"09:50","arrivaltime":"15:43","sequenceno":7,"costtime":"5时53分","distance":1279,"isend":1,"trainno12306":"5600000G4650","pricesw":1701,"pricetd":null,"pricegr1":null,"pricegr2":null,"pricerw1":null,"pricerw2":null,"priceyw1":null,"priceyw2":null,"priceyw3":null,"typename":"高铁","priceyd":"907.0","priceed":"538.5"},{"trainno":"G38","type":"G","station":"杭州东","endstation":"北京南","departuretime":"11:34","arrivaltime":"18:09","sequenceno":7,"costtime":"6时35分","distance":0,"isend":1,"trainno12306":"5u00000G380I","pricesw":1701,"pricetd":1025.5,"pricegr1":null,"pricegr2":null,"pricerw1":null,"pricerw2":null,"priceyw1":null,"priceyw2":null,"priceyw3":null,"typename":"高铁","priceyd":"907.0","priceed":"538.5"},{"trainno":"G168","type":"G","station":"杭州东","endstation":"北京南","departuretime":"11:39","arrivaltime":"18:13","sequenceno":9,"costtime":"6时34分","distance":0,"isend":1,"trainno12306":"5j0000G16822","pricesw":1701,"pricetd":null,"pricegr1":null,"pricegr2":null,"pricerw1":null,"pricerw2":null,"priceyw1":null,"priceyw2":null,"priceyw3":null,"typename":"高铁","priceyd":"907.0","priceed":"538.5"},{"trainno":"G56","type":"G","station":"杭州东","endstation":"北京南","departuretime":"12:47","arrivaltime":"18:58","sequenceno":10,"costtime":"1天6时11分","distance":0,"isend":1,"trainno12306":"5800000G560J","pricesw":1701,"pricetd":null,"pricegr1":null,"pricegr2":null,"pricerw1":null,"pricerw2":null,"priceyw1":null,"priceyw2":null,"priceyw3":null,"typename":"高铁","priceyd":"907.0","priceed":"538.5"},{"trainno":"G164","type":"G","station":"杭州东","endstation":"北京南","departuretime":"13:41","arrivaltime":"19:53","sequenceno":13,"costtime":"6时12分","distance":0,"isend":1,"trainno12306":"5j0000G16422","pricesw":1701,"pricetd":null,"pricegr1":null,"pricegr2":null,"pricerw1":null,"pricerw2":null,"priceyw1":null,"priceyw2":null,"priceyw3":null,"typename":"高铁","priceyd":"907.0","priceed":"538.5"},{"trainno":"G166","type":"G","station":"杭州东","endstation":"北京南","departuretime":"15:12","arrivaltime":"20:58","sequenceno":2,"costtime":"5时46分","distance":1236,"isend":1,"trainno12306":"5t0000G16600","pricesw":1701,"pricetd":null,"pricegr1":null,"pricegr2":null,"pricerw1":null,"pricerw2":null,"priceyw1":null,"priceyw2":null,"priceyw3":null,"typename":"高铁","priceyd":"907.0","priceed":"538.5"},{"trainno":"G44","type":"G","station":"杭州东","endstation":"北京南","departuretime":"16:15","arrivaltime":"23:08","sequenceno":1,"costtime":"6时53分","distance":1477,"isend":1,"trainno12306":"5600000G4400","pricesw":1966,"pricetd":null,"pricegr1":null,"pricegr2":null,"pricerw1":null,"pricerw2":null,"priceyw1":null,"priceyw2":null,"priceyw3":null,"typename":"高铁","priceyd":"1048.5","priceed":"626.0"},{"trainno":"Z282","type":"Z","station":"杭州","endstation":"北京","departuretime":"17:04","arrivaltime":"10:22","sequenceno":1,"costtime":"17时18分","distance":0,"isend":0,"trainno12306":"560000Z28230","pricesw":611,"pricetd":null,"pricerz":305,"priceyz":192,"pricegr1":555,"pricegr2":null,"pricerw1":515,"pricerw2":null,"priceyw1":328,"priceyw2":null,"priceyw3":null,"typename":"直达特快"},{"trainno":"D718","type":"D","station":"杭州","endstation":"北京","departuretime":"17:32","arrivaltime":"07:07","sequenceno":1,"costtime":"13时35分","distance":0,"isend":1,"trainno12306":"560000D71800","pricesw":null,"pricetd":null,"pricegr1":null,"pricegr2":null,"pricerw1":null,"pricerw2":null,"priceyw1":null,"priceyw2":null,"priceyw3":null,"typename":"动车","priceyd":"393.0","priceed":"328.0"},{"trainno":"G40","type":"G","station":"杭州东","endstation":"北京南","departuretime":"19:00","arrivaltime":"23:23","sequenceno":5,"costtime":"4时23分","distance":0,"isend":1,"trainno12306":"5600000G4070","pricesw":1701,"pricetd":1025.5,"pricegr1":null,"pricegr2":null,"pricerw1":null,"pricerw2":null,"priceyw1":null,"priceyw2":null,"priceyw3":null,"typename":"高铁","priceyd":"907.0","priceed":"538.5"},{"trainno":"D712","type":"D","station":"杭州","endstation":"北京","departuretime":"20:05","arrivaltime":"09:36","sequenceno":1,"costtime":"13时31分","distance":0,"isend":1,"trainno12306":"560000D71201","pricesw":null,"pricetd":null,"pricegr1":null,"pricegr2":null,"pricerw1":null,"pricerw2":null,"priceyw1":null,"priceyw2":null,"priceyw3":null,"typename":"动车","priceyd":"363.0","priceed":"302.0"}]}
     */

    private int status;
    private String msg;
    private ResultBean result;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * start : 杭州
         * end : 北京
         * ishigh : 0
         * date : 2019-12-16
         * list : [{"trainno":"G34","type":"G","station":"杭州东","endstation":"北京南","departuretime":"06:55","arrivaltime":"13:03","sequenceno":1,"costtime":"6时8分","distance":0,"isend":1,"trainno12306":"5600000G3490","pricesw":1701,"pricetd":1025.5,"pricegr1":null,"pricegr2":null,"pricerw1":null,"pricerw2":null,"priceyw1":null,"priceyw2":null,"priceyw3":null,"typename":"高铁","priceyd":"907.0","priceed":"538.5"},{"trainno":"G58","type":"G","station":"杭州东","endstation":"北京南","departuretime":"08:50","arrivaltime":"14:43","sequenceno":5,"costtime":"5时53分","distance":0,"isend":1,"trainno12306":"5e00000G5840","pricesw":1701,"pricetd":1025.5,"pricegr1":null,"pricegr2":null,"pricerw1":null,"pricerw2":null,"priceyw1":null,"priceyw2":null,"priceyw3":null,"typename":"高铁","priceyd":"907.0","priceed":"538.5"},{"trainno":"G46","type":"G","station":"杭州东","endstation":"北京南","departuretime":"09:50","arrivaltime":"15:43","sequenceno":7,"costtime":"5时53分","distance":1279,"isend":1,"trainno12306":"5600000G4650","pricesw":1701,"pricetd":null,"pricegr1":null,"pricegr2":null,"pricerw1":null,"pricerw2":null,"priceyw1":null,"priceyw2":null,"priceyw3":null,"typename":"高铁","priceyd":"907.0","priceed":"538.5"},{"trainno":"G38","type":"G","station":"杭州东","endstation":"北京南","departuretime":"11:34","arrivaltime":"18:09","sequenceno":7,"costtime":"6时35分","distance":0,"isend":1,"trainno12306":"5u00000G380I","pricesw":1701,"pricetd":1025.5,"pricegr1":null,"pricegr2":null,"pricerw1":null,"pricerw2":null,"priceyw1":null,"priceyw2":null,"priceyw3":null,"typename":"高铁","priceyd":"907.0","priceed":"538.5"},{"trainno":"G168","type":"G","station":"杭州东","endstation":"北京南","departuretime":"11:39","arrivaltime":"18:13","sequenceno":9,"costtime":"6时34分","distance":0,"isend":1,"trainno12306":"5j0000G16822","pricesw":1701,"pricetd":null,"pricegr1":null,"pricegr2":null,"pricerw1":null,"pricerw2":null,"priceyw1":null,"priceyw2":null,"priceyw3":null,"typename":"高铁","priceyd":"907.0","priceed":"538.5"},{"trainno":"G56","type":"G","station":"杭州东","endstation":"北京南","departuretime":"12:47","arrivaltime":"18:58","sequenceno":10,"costtime":"1天6时11分","distance":0,"isend":1,"trainno12306":"5800000G560J","pricesw":1701,"pricetd":null,"pricegr1":null,"pricegr2":null,"pricerw1":null,"pricerw2":null,"priceyw1":null,"priceyw2":null,"priceyw3":null,"typename":"高铁","priceyd":"907.0","priceed":"538.5"},{"trainno":"G164","type":"G","station":"杭州东","endstation":"北京南","departuretime":"13:41","arrivaltime":"19:53","sequenceno":13,"costtime":"6时12分","distance":0,"isend":1,"trainno12306":"5j0000G16422","pricesw":1701,"pricetd":null,"pricegr1":null,"pricegr2":null,"pricerw1":null,"pricerw2":null,"priceyw1":null,"priceyw2":null,"priceyw3":null,"typename":"高铁","priceyd":"907.0","priceed":"538.5"},{"trainno":"G166","type":"G","station":"杭州东","endstation":"北京南","departuretime":"15:12","arrivaltime":"20:58","sequenceno":2,"costtime":"5时46分","distance":1236,"isend":1,"trainno12306":"5t0000G16600","pricesw":1701,"pricetd":null,"pricegr1":null,"pricegr2":null,"pricerw1":null,"pricerw2":null,"priceyw1":null,"priceyw2":null,"priceyw3":null,"typename":"高铁","priceyd":"907.0","priceed":"538.5"},{"trainno":"G44","type":"G","station":"杭州东","endstation":"北京南","departuretime":"16:15","arrivaltime":"23:08","sequenceno":1,"costtime":"6时53分","distance":1477,"isend":1,"trainno12306":"5600000G4400","pricesw":1966,"pricetd":null,"pricegr1":null,"pricegr2":null,"pricerw1":null,"pricerw2":null,"priceyw1":null,"priceyw2":null,"priceyw3":null,"typename":"高铁","priceyd":"1048.5","priceed":"626.0"},{"trainno":"Z282","type":"Z","station":"杭州","endstation":"北京","departuretime":"17:04","arrivaltime":"10:22","sequenceno":1,"costtime":"17时18分","distance":0,"isend":0,"trainno12306":"560000Z28230","pricesw":611,"pricetd":null,"pricerz":305,"priceyz":192,"pricegr1":555,"pricegr2":null,"pricerw1":515,"pricerw2":null,"priceyw1":328,"priceyw2":null,"priceyw3":null,"typename":"直达特快"},{"trainno":"D718","type":"D","station":"杭州","endstation":"北京","departuretime":"17:32","arrivaltime":"07:07","sequenceno":1,"costtime":"13时35分","distance":0,"isend":1,"trainno12306":"560000D71800","pricesw":null,"pricetd":null,"pricegr1":null,"pricegr2":null,"pricerw1":null,"pricerw2":null,"priceyw1":null,"priceyw2":null,"priceyw3":null,"typename":"动车","priceyd":"393.0","priceed":"328.0"},{"trainno":"G40","type":"G","station":"杭州东","endstation":"北京南","departuretime":"19:00","arrivaltime":"23:23","sequenceno":5,"costtime":"4时23分","distance":0,"isend":1,"trainno12306":"5600000G4070","pricesw":1701,"pricetd":1025.5,"pricegr1":null,"pricegr2":null,"pricerw1":null,"pricerw2":null,"priceyw1":null,"priceyw2":null,"priceyw3":null,"typename":"高铁","priceyd":"907.0","priceed":"538.5"},{"trainno":"D712","type":"D","station":"杭州","endstation":"北京","departuretime":"20:05","arrivaltime":"09:36","sequenceno":1,"costtime":"13时31分","distance":0,"isend":1,"trainno12306":"560000D71201","pricesw":null,"pricetd":null,"pricegr1":null,"pricegr2":null,"pricerw1":null,"pricerw2":null,"priceyw1":null,"priceyw2":null,"priceyw3":null,"typename":"动车","priceyd":"363.0","priceed":"302.0"}]
         */

        private String start;
        private String end;
        private String ishigh;
        private String date;
        private List<ListBean> list;

        public String getStart() {
            return start;
        }

        public void setStart(String start) {
            this.start = start;
        }

        public String getEnd() {
            return end;
        }

        public void setEnd(String end) {
            this.end = end;
        }

        public String getIshigh() {
            return ishigh;
        }

        public void setIshigh(String ishigh) {
            this.ishigh = ishigh;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * trainno : G34
             * type : G
             * station : 杭州东
             * endstation : 北京南
             * departuretime : 06:55
             * arrivaltime : 13:03
             * sequenceno : 1
             * costtime : 6时8分
             * distance : 0
             * isend : 1
             * trainno12306 : 5600000G3490
             * pricesw : 1701
             * pricetd : 1025.5
             * pricegr1 : null
             * pricegr2 : null
             * pricerw1 : null
             * pricerw2 : null
             * priceyw1 : null
             * priceyw2 : null
             * priceyw3 : null
             * typename : 高铁
             * priceyd : 907.0
             * priceed : 538.5
             * pricerz : 305
             * priceyz : 192
             */

            private String trainno;
            private String type;
            private String station;
            private String endstation;
            private String departuretime;
            private String arrivaltime;
            private int sequenceno;
            private String costtime;
            private int distance;
            private int isend;
            private String trainno12306;
//            private int pricesw;
//            private double pricetd;
//            private Object pricegr1;
//            private Object pricegr2;
//            private Object pricerw1;
//            private Object pricerw2;
//            private Object priceyw1;
//            private Object priceyw2;
//            private Object priceyw3;
            private String typename;
//            private String priceyd;
//            private String priceed;
//            private int pricerz;
//            private int priceyz;

            public String getTrainno() {
                return trainno;
            }

            public void setTrainno(String trainno) {
                this.trainno = trainno;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getStation() {
                return station;
            }

            public void setStation(String station) {
                this.station = station;
            }

            public String getEndstation() {
                return endstation;
            }

            public void setEndstation(String endstation) {
                this.endstation = endstation;
            }

            public String getDeparturetime() {
                return departuretime;
            }

            public void setDeparturetime(String departuretime) {
                this.departuretime = departuretime;
            }

            public String getArrivaltime() {
                return arrivaltime;
            }

            public void setArrivaltime(String arrivaltime) {
                this.arrivaltime = arrivaltime;
            }

            public int getSequenceno() {
                return sequenceno;
            }

            public void setSequenceno(int sequenceno) {
                this.sequenceno = sequenceno;
            }

            public String getCosttime() {
                return costtime;
            }

            public void setCosttime(String costtime) {
                this.costtime = costtime;
            }

            public int getDistance() {
                return distance;
            }

            public void setDistance(int distance) {
                this.distance = distance;
            }

            public int getIsend() {
                return isend;
            }

            public void setIsend(int isend) {
                this.isend = isend;
            }

            public String getTrainno12306() {
                return trainno12306;
            }

            public void setTrainno12306(String trainno12306) {
                this.trainno12306 = trainno12306;
            }

//            public int getPricesw() {
//                return pricesw;
//            }
//
//            public void setPricesw(int pricesw) {
//                this.pricesw = pricesw;
//            }

//            public double getPricetd() {
//                return pricetd;
//            }
//
//            public void setPricetd(double pricetd) {
//                this.pricetd = pricetd;
//            }
//
//            public Object getPricegr1() {
//                return pricegr1;
//            }
//
//            public void setPricegr1(Object pricegr1) {
//                this.pricegr1 = pricegr1;
//            }
//
//            public Object getPricegr2() {
//                return pricegr2;
//            }
//
//            public void setPricegr2(Object pricegr2) {
//                this.pricegr2 = pricegr2;
//            }
//
//            public Object getPricerw1() {
//                return pricerw1;
//            }
//
//            public void setPricerw1(Object pricerw1) {
//                this.pricerw1 = pricerw1;
//            }
//
//            public Object getPricerw2() {
//                return pricerw2;
//            }
//
//            public void setPricerw2(Object pricerw2) {
//                this.pricerw2 = pricerw2;
//            }
//
//            public Object getPriceyw1() {
//                return priceyw1;
//            }
//
//            public void setPriceyw1(Object priceyw1) {
//                this.priceyw1 = priceyw1;
//            }
//
//            public Object getPriceyw2() {
//                return priceyw2;
//            }
//
//            public void setPriceyw2(Object priceyw2) {
//                this.priceyw2 = priceyw2;
//            }
//
//            public Object getPriceyw3() {
//                return priceyw3;
//            }
//
//            public void setPriceyw3(Object priceyw3) {
//                this.priceyw3 = priceyw3;
//            }

            public String getTypename() {
                return typename;
            }

            public void setTypename(String typename) {
                this.typename = typename;
            }

//            public String getPriceyd() {
//                return priceyd;
//            }
//
//            public void setPriceyd(String priceyd) {
//                this.priceyd = priceyd;
//            }
//
//            public String getPriceed() {
//                return priceed;
//            }
//
//            public void setPriceed(String priceed) {
//                this.priceed = priceed;
//            }

//            public int getPricerz() {
//                return pricerz;
//            }
//
//            public void setPricerz(int pricerz) {
//                this.pricerz = pricerz;
//            }

//            public int getPriceyz() {
//                return priceyz;
//            }
//
//            public void setPriceyz(int priceyz) {
//                this.priceyz = priceyz;
//            }
        }
    }
}
