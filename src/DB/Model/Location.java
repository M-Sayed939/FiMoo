package DB.Model;

public class Location {
        private int locationId;
        private String streetAddress;
        private String postalCode;
        private String city;
        private String stateProvince;
        private String countryID;

        public int getLocationId() {
            return locationId;
        }

        public void setLocationId(int locationId) {
            this.locationId = locationId;
        }

        public String getStreetAddress() {
            return streetAddress;
        }

        public void setStreetAddress(String streetAddress) {
            this.streetAddress = streetAddress;
        }

        public String getPostalCode() {
            return postalCode;
        }

        public void setPostalCode(String postalCode) {
            this.postalCode = postalCode;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getStateProvince() {
            return stateProvince;
        }

        public void setStateProvince(String stateProvince) {
            this.stateProvince = stateProvince;
        }

        public String getCountryID() {
            return countryID;
        }

        public void setCountryID(String countryID) {
            this.countryID = countryID;
        }

        @Override
        public String toString() {
            return "Location{" +
                    "locationId=" + locationId +
                    ", streetAddress='" + streetAddress + '\'' +
                    ", postalCode='" + postalCode + '\'' +
                    ", city='" + city + '\'' +
                    ", stateProvince='" + stateProvince + '\'' +
                    ", countryID='" + countryID + '\'' +
                    '}';
        }
    }


