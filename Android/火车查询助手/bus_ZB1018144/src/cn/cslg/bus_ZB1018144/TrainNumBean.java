package cn.cslg.bus_ZB1018144;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Alice on 2019/12/21.
 */
public class TrainNumBean  implements Serializable {


    /**
     * status : 0
     * msg : ok
     * result : {"trainno":"G34","startstation":"杭州东","endstation":"北京南","type":"G","date":"2019-12-21","trainno12306":"","typename":"高铁","list":[{"sequenceno":1,"station":"杭州东","day":1,"arrivaltime":"06:55","departuretime":"06:55","stoptime":0,"costtime":0,"distance":0,"isend":0,"pricesw":null,"pricetd":null,"pricegr1":null,"pricegr2":null,"pricerw1":null,"pricerw2":null,"priceyw1":null,"priceyw2":null,"priceyw3":null,"priceyd":null,"priceed":null},{"sequenceno":2,"station":"德清","day":1,"arrivaltime":"07:08","departuretime":"07:10","stoptime":2,"costtime":13,"distance":0,"isend":0,"pricesw":50.5,"pricetd":30.5,"pricegr1":null,"pricegr2":null,"pricerw1":null,"pricerw2":null,"priceyw1":null,"priceyw2":null,"priceyw3":null,"priceyd":"27.0","priceed":"16.0"},{"sequenceno":3,"station":"湖州","day":1,"arrivaltime":"07:23","departuretime":"07:25","stoptime":2,"costtime":28,"distance":0,"isend":0,"pricesw":103,"pricetd":62,"pricegr1":null,"pricegr2":null,"pricerw1":null,"pricerw2":null,"priceyw1":null,"priceyw2":null,"priceyw3":null,"priceyd":"55.0","priceed":"32.5"},{"sequenceno":4,"station":"宜兴","day":1,"arrivaltime":"07:42","departuretime":"07:44","stoptime":2,"costtime":47,"distance":0,"isend":0,"pricesw":184,"pricetd":111,"pricegr1":null,"pricegr2":null,"pricerw1":null,"pricerw2":null,"priceyw1":null,"priceyw2":null,"priceyw3":null,"priceyd":"98.0","priceed":"58.5"},{"sequenceno":5,"station":"溧阳","day":1,"arrivaltime":"07:55","departuretime":"07:57","stoptime":2,"costtime":60,"distance":0,"isend":0,"pricesw":229,"pricetd":138,"pricegr1":null,"pricegr2":null,"pricerw1":null,"pricerw2":null,"priceyw1":null,"priceyw2":null,"priceyw3":null,"priceyd":"122.0","priceed":"72.5"},{"sequenceno":6,"station":"溧水","day":1,"arrivaltime":"08:13","departuretime":"08:15","stoptime":2,"costtime":78,"distance":0,"isend":0,"pricesw":304.5,"pricetd":183.5,"pricegr1":null,"pricegr2":null,"pricerw1":null,"pricerw2":null,"priceyw1":null,"priceyw2":null,"priceyw3":null,"priceyd":"162.5","priceed":"96.5"},{"sequenceno":7,"station":"南京南","day":1,"arrivaltime":"08:31","departuretime":"08:33","stoptime":2,"costtime":96,"distance":0,"isend":0,"pricesw":371,"pricetd":223.5,"pricegr1":null,"pricegr2":null,"pricerw1":null,"pricerw2":null,"priceyw1":null,"priceyw2":null,"priceyw3":null,"priceyd":"198.0","priceed":"117.5"},{"sequenceno":8,"station":"宿州东","day":1,"arrivaltime":"09:33","departuretime":"09:35","stoptime":2,"costtime":158,"distance":0,"isend":0,"pricesw":749.5,"pricetd":452,"pricegr1":null,"pricegr2":null,"pricerw1":null,"pricerw2":null,"priceyw1":null,"priceyw2":null,"priceyw3":null,"priceyd":"400.0","priceed":"237.5"},{"sequenceno":9,"station":"徐州东","day":1,"arrivaltime":"09:53","departuretime":"10:09","stoptime":16,"costtime":178,"distance":0,"isend":0,"pricesw":838.5,"pricetd":505.5,"pricegr1":null,"pricegr2":null,"pricerw1":null,"pricerw2":null,"priceyw1":null,"priceyw2":null,"priceyw3":null,"priceyd":"447.0","priceed":"265.5"},{"sequenceno":10,"station":"泰安","day":1,"arrivaltime":"11:00","departuretime":"11:04","stoptime":4,"costtime":245,"distance":0,"isend":0,"pricesw":1134.5,"pricetd":684,"pricegr1":null,"pricegr2":null,"pricerw1":null,"pricerw2":null,"priceyw1":null,"priceyw2":null,"priceyw3":null,"priceyd":"605.0","priceed":"359.5"},{"sequenceno":11,"station":"济南西","day":1,"arrivaltime":"11:21","departuretime":"11:24","stoptime":3,"costtime":266,"distance":0,"isend":0,"pricesw":1211.5,"pricetd":730.5,"pricegr1":null,"pricegr2":null,"pricerw1":null,"pricerw2":null,"priceyw1":null,"priceyw2":null,"priceyw3":null,"priceyd":"646.0","priceed":"383.5"},{"sequenceno":12,"station":"沧州西","day":1,"arrivaltime":"12:10","departuretime":"12:12","stoptime":2,"costtime":315,"distance":0,"isend":0,"pricesw":1457.5,"pricetd":878.5,"pricegr1":null,"pricegr2":null,"pricerw1":null,"pricerw2":null,"priceyw1":null,"priceyw2":null,"priceyw3":null,"priceyd":"777.5","priceed":"461.5"},{"sequenceno":13,"station":"北京南","day":1,"arrivaltime":"13:03","departuretime":"13:03","stoptime":0,"costtime":368,"distance":0,"isend":1,"pricesw":1701,"pricetd":1025.5,"pricegr1":null,"pricegr2":null,"pricerw1":null,"pricerw2":null,"priceyw1":null,"priceyw2":null,"priceyw3":null,"priceyd":"907.0","priceed":"538.5","costtimetxt":"6时8分"}]}
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
         * trainno : G34
         * startstation : 杭州东
         * endstation : 北京南
         * type : G
         * date : 2019-12-21
         * trainno12306 :
         * typename : 高铁
         * list : [{"sequenceno":1,"station":"杭州东","day":1,"arrivaltime":"06:55","departuretime":"06:55","stoptime":0,"costtime":0,"distance":0,"isend":0,"pricesw":null,"pricetd":null,"pricegr1":null,"pricegr2":null,"pricerw1":null,"pricerw2":null,"priceyw1":null,"priceyw2":null,"priceyw3":null,"priceyd":null,"priceed":null},{"sequenceno":2,"station":"德清","day":1,"arrivaltime":"07:08","departuretime":"07:10","stoptime":2,"costtime":13,"distance":0,"isend":0,"pricesw":50.5,"pricetd":30.5,"pricegr1":null,"pricegr2":null,"pricerw1":null,"pricerw2":null,"priceyw1":null,"priceyw2":null,"priceyw3":null,"priceyd":"27.0","priceed":"16.0"},{"sequenceno":3,"station":"湖州","day":1,"arrivaltime":"07:23","departuretime":"07:25","stoptime":2,"costtime":28,"distance":0,"isend":0,"pricesw":103,"pricetd":62,"pricegr1":null,"pricegr2":null,"pricerw1":null,"pricerw2":null,"priceyw1":null,"priceyw2":null,"priceyw3":null,"priceyd":"55.0","priceed":"32.5"},{"sequenceno":4,"station":"宜兴","day":1,"arrivaltime":"07:42","departuretime":"07:44","stoptime":2,"costtime":47,"distance":0,"isend":0,"pricesw":184,"pricetd":111,"pricegr1":null,"pricegr2":null,"pricerw1":null,"pricerw2":null,"priceyw1":null,"priceyw2":null,"priceyw3":null,"priceyd":"98.0","priceed":"58.5"},{"sequenceno":5,"station":"溧阳","day":1,"arrivaltime":"07:55","departuretime":"07:57","stoptime":2,"costtime":60,"distance":0,"isend":0,"pricesw":229,"pricetd":138,"pricegr1":null,"pricegr2":null,"pricerw1":null,"pricerw2":null,"priceyw1":null,"priceyw2":null,"priceyw3":null,"priceyd":"122.0","priceed":"72.5"},{"sequenceno":6,"station":"溧水","day":1,"arrivaltime":"08:13","departuretime":"08:15","stoptime":2,"costtime":78,"distance":0,"isend":0,"pricesw":304.5,"pricetd":183.5,"pricegr1":null,"pricegr2":null,"pricerw1":null,"pricerw2":null,"priceyw1":null,"priceyw2":null,"priceyw3":null,"priceyd":"162.5","priceed":"96.5"},{"sequenceno":7,"station":"南京南","day":1,"arrivaltime":"08:31","departuretime":"08:33","stoptime":2,"costtime":96,"distance":0,"isend":0,"pricesw":371,"pricetd":223.5,"pricegr1":null,"pricegr2":null,"pricerw1":null,"pricerw2":null,"priceyw1":null,"priceyw2":null,"priceyw3":null,"priceyd":"198.0","priceed":"117.5"},{"sequenceno":8,"station":"宿州东","day":1,"arrivaltime":"09:33","departuretime":"09:35","stoptime":2,"costtime":158,"distance":0,"isend":0,"pricesw":749.5,"pricetd":452,"pricegr1":null,"pricegr2":null,"pricerw1":null,"pricerw2":null,"priceyw1":null,"priceyw2":null,"priceyw3":null,"priceyd":"400.0","priceed":"237.5"},{"sequenceno":9,"station":"徐州东","day":1,"arrivaltime":"09:53","departuretime":"10:09","stoptime":16,"costtime":178,"distance":0,"isend":0,"pricesw":838.5,"pricetd":505.5,"pricegr1":null,"pricegr2":null,"pricerw1":null,"pricerw2":null,"priceyw1":null,"priceyw2":null,"priceyw3":null,"priceyd":"447.0","priceed":"265.5"},{"sequenceno":10,"station":"泰安","day":1,"arrivaltime":"11:00","departuretime":"11:04","stoptime":4,"costtime":245,"distance":0,"isend":0,"pricesw":1134.5,"pricetd":684,"pricegr1":null,"pricegr2":null,"pricerw1":null,"pricerw2":null,"priceyw1":null,"priceyw2":null,"priceyw3":null,"priceyd":"605.0","priceed":"359.5"},{"sequenceno":11,"station":"济南西","day":1,"arrivaltime":"11:21","departuretime":"11:24","stoptime":3,"costtime":266,"distance":0,"isend":0,"pricesw":1211.5,"pricetd":730.5,"pricegr1":null,"pricegr2":null,"pricerw1":null,"pricerw2":null,"priceyw1":null,"priceyw2":null,"priceyw3":null,"priceyd":"646.0","priceed":"383.5"},{"sequenceno":12,"station":"沧州西","day":1,"arrivaltime":"12:10","departuretime":"12:12","stoptime":2,"costtime":315,"distance":0,"isend":0,"pricesw":1457.5,"pricetd":878.5,"pricegr1":null,"pricegr2":null,"pricerw1":null,"pricerw2":null,"priceyw1":null,"priceyw2":null,"priceyw3":null,"priceyd":"777.5","priceed":"461.5"},{"sequenceno":13,"station":"北京南","day":1,"arrivaltime":"13:03","departuretime":"13:03","stoptime":0,"costtime":368,"distance":0,"isend":1,"pricesw":1701,"pricetd":1025.5,"pricegr1":null,"pricegr2":null,"pricerw1":null,"pricerw2":null,"priceyw1":null,"priceyw2":null,"priceyw3":null,"priceyd":"907.0","priceed":"538.5","costtimetxt":"6时8分"}]
         */

        private String trainno;
        private String startstation;
        private String endstation;
        private String type;
        private String date;
        private String trainno12306;
        private String typename;
        private List<ListBean> list;

        public String getTrainno() {
            return trainno;
        }

        public void setTrainno(String trainno) {
            this.trainno = trainno;
        }

        public String getStartstation() {
            return startstation;
        }

        public void setStartstation(String startstation) {
            this.startstation = startstation;
        }

        public String getEndstation() {
            return endstation;
        }

        public void setEndstation(String endstation) {
            this.endstation = endstation;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTrainno12306() {
            return trainno12306;
        }

        public void setTrainno12306(String trainno12306) {
            this.trainno12306 = trainno12306;
        }

        public String getTypename() {
            return typename;
        }

        public void setTypename(String typename) {
            this.typename = typename;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * sequenceno : 1
             * station : 杭州东
             * day : 1
             * arrivaltime : 06:55
             * departuretime : 06:55
             * stoptime : 0
             * costtime : 0
             * distance : 0
             * isend : 0
             * pricesw : null
             * pricetd : null
             * pricegr1 : null
             * pricegr2 : null
             * pricerw1 : null
             * pricerw2 : null
             * priceyw1 : null
             * priceyw2 : null
             * priceyw3 : null
             * priceyd : null
             * priceed : null
             * costtimetxt : 6时8分
             */

            private String sequenceno;
            private String station;
            private int day;
            private String arrivaltime;
            private String departuretime;
            private String stoptime;
            private int costtime;
            private int distance;
            private int isend;
            private Object pricesw;
            private Object pricetd;
            private Object pricegr1;
            private Object pricegr2;
            private Object pricerw1;
            private Object pricerw2;
            private Object priceyw1;
            private Object priceyw2;
            private Object priceyw3;
            private Object priceyd;
            private Object priceed;
            private String costtimetxt;

            public String getSequenceno() {
                return sequenceno;
            }

            public void setSequenceno(String sequenceno) {
                this.sequenceno = sequenceno;
            }

            public String getStation() {
                return station;
            }

            public void setStation(String station) {
                this.station = station;
            }

            public int getDay() {
                return day;
            }

            public void setDay(int day) {
                this.day = day;
            }

            public String getArrivaltime() {
                return arrivaltime;
            }

            public void setArrivaltime(String arrivaltime) {
                this.arrivaltime = arrivaltime;
            }

            public String getDeparturetime() {
                return departuretime;
            }

            public void setDeparturetime(String departuretime) {
                this.departuretime = departuretime;
            }

            public String getStoptime() {
                return stoptime;
            }

            public void setStoptime(String stoptime) {
                this.stoptime = stoptime;
            }

            public int getCosttime() {
                return costtime;
            }

            public void setCosttime(int costtime) {
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

            public Object getPricesw() {
                return pricesw;
            }

            public void setPricesw(Object pricesw) {
                this.pricesw = pricesw;
            }

            public Object getPricetd() {
                return pricetd;
            }

            public void setPricetd(Object pricetd) {
                this.pricetd = pricetd;
            }

            public Object getPricegr1() {
                return pricegr1;
            }

            public void setPricegr1(Object pricegr1) {
                this.pricegr1 = pricegr1;
            }

            public Object getPricegr2() {
                return pricegr2;
            }

            public void setPricegr2(Object pricegr2) {
                this.pricegr2 = pricegr2;
            }

            public Object getPricerw1() {
                return pricerw1;
            }

            public void setPricerw1(Object pricerw1) {
                this.pricerw1 = pricerw1;
            }

            public Object getPricerw2() {
                return pricerw2;
            }

            public void setPricerw2(Object pricerw2) {
                this.pricerw2 = pricerw2;
            }

            public Object getPriceyw1() {
                return priceyw1;
            }

            public void setPriceyw1(Object priceyw1) {
                this.priceyw1 = priceyw1;
            }

            public Object getPriceyw2() {
                return priceyw2;
            }

            public void setPriceyw2(Object priceyw2) {
                this.priceyw2 = priceyw2;
            }

            public Object getPriceyw3() {
                return priceyw3;
            }

            public void setPriceyw3(Object priceyw3) {
                this.priceyw3 = priceyw3;
            }

            public Object getPriceyd() {
                return priceyd;
            }

            public void setPriceyd(Object priceyd) {
                this.priceyd = priceyd;
            }

            public Object getPriceed() {
                return priceed;
            }

            public void setPriceed(Object priceed) {
                this.priceed = priceed;
            }

            public String getCosttimetxt() {
                return costtimetxt;
            }

            public void setCosttimetxt(String costtimetxt) {
                this.costtimetxt = costtimetxt;
            }
        }
    }
}
