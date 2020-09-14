/**
 * End points for server 
 */

app.service('serverEndpoints', function() {

    return {

        /****** URLs ****************/

        // Development environment
        hostname: "",
        baseUrl: "/",
        baseFilesUrl: "/PACKAGE_CRM_FILES/",
        baseFileUrl:"/OFFERPAGE_CRM_FILES/",
        pushToken:"pushToken",

        // Staging environment
        /*hostname:"http://139.59.59.220:8080/",
        baseUrl:"http://139.59.59.220:8080/NvieinWS/",
        baseFilesUrl:"http://139.59.59.220:8080/UserImages/",*/

        // Production environment
        /*hostname:"http://www.zugmug.com/",
        baseUrl:"http://www.zugmug.com/NvieinWS/",
        baseFilesUrl:"http://www.zugmug.com/UserImages/",*/

        //WebAPI
        loginAdminUrl:"loginAdmin",
        registerUserUrl:"registerUser",
        loginUserUrl:"loginUser",
        findAllUsersUrl:"findAllUsers",
        deleteUserByIdUrl:"deleteUserById",
        
        AddRoomUrl:"AddRoom",
        showAllRoomsUrl:"showAllRooms",
        findRoomByTypeUrl:"findRoomByType",
        findRoomByDateUrl:"findRoomByDate",
        findRoomByRoomNoUrl:"findRoomByRoomNo",
        findRoomByCapacityUrl:"findRoomByCapacity",
        deleteRoomByIdUrl:"deleteRoomById",
        
        registerRoomUrl:"registerRoom",
        ShowAllReservationsUrl:"ShowAllReservations", 
        findReservationByUserIdUrl:"findReservationByUserId",
        DeleteReservationUrl:"DeleteReservation",
        getRoomsByAvaibilityUrl:"getRoomsByAvaibility",
        
        
        //old

        getAllCustomersUrl:"getAllCustomers",
        registerNewCustomerUrl:"registerNewCustomer",
        loginAdminUrl:"loginAdmin",
        getCustomerByIdUrl:"getCustomerById",
        updateCustomerUrl:"updateCustomer",
        getSearchedCustomersUrl:"getSearchedCustomers",
        getListOfCustomerVisaDetailsUrl:"getListOfCustomerVisaDetails",
        getWeeksBirthDayUrl:"getWeeksBirthDay",
        registerCustomersFromExcelUrl:"registerCustomersFromExcel",
        logincustomerUrl:"logincustomer",
        pvtgetAllCustomersUrl:"pvtgetAllCustomers",
        pvtGetCustomerByIdUrl:"pvtGetCustomerById",
        removecustomerUrl:"removecustomer",
        loginSuperAdminUrl:"loginSuperAdmin",
        getAllAdminsUrl:"getAllAdmins",
        registerAdminUrl:"registerAdmin",
        updateAdminUrl:"updateAdmin",
        getAllRolesUrl:"getAllRoles",
        getRolesByCustomerIdUrl:"getRolesByCustomerId",
        assignRolesToUserUrl:"assignRolesToUser",
        getMasterDatasUrl:"getMasterDatas",
        registerNewEnquiryUrl:"registerNewEnquiry",
        getEnquiriesCreatedBySalesUrl:"getEnquiriesCreatedBySales",
        getAssigniedEnquiriesToOperationHeadUrl:"getAssigniedEnquiriesToOperationHead",
        getRoleWiseCustomersUrl:"getRoleWiseCustomers",
        assignEnquiriesToRoleUrl:"assignEnquiriesToRole",
        getEnquirieDetailsByIdUrl:"getEnquirieDetailsById",
        updateEnquiryUrl:"updateEnquiry",
        getAllAirportsUrl:"getAllAirports",
        getAllCountriesUrl:"getAllCountries",
        getAllCitiesOfCountriesUrl:"getAllCitiesOfCountries",
        getAllPopularCountriesUrl:"getAllPopularCountries",
        getAllPopularCitiesOfCountriesUrl:"getAllPopularCitiesOfCountries",
        updateEnquiryRemarkUrl:"updateEnquiryRemark",
        registerNewConsumerUrl:"registerNewConsumer",
        updateConsumerUrl:"updateConsumer",
        getAllConsumerByCustomerIdUrl:"getAllConsumerByCustomerId",
        getConsumerByIdUrl:"getConsumerById",
        getSearchedConsumerByCustomerIdUrl:"getSearchedConsumerByCustomerId",
        removeconsumerUrl:"removeconsumer",
        createPackageUrl:"createPackage",
        uploadFilesUrl:"uploadFiles",
        getAllPackagesByCustomerUrl:"getAllPackagesByCustomer",
        getPackageDetailsByPackageNameUrl:"getPackageDetailsByPackageName",
        updatepackageUrl:"updatepackage",
        createIternaryForPackageUrl:"createIternaryForPackage",
        getIternaryDetailsByPackageIdUrl:"getIternaryDetailsByPackageId",
        loginUserUrl:"loginUser",
        checkIfUserLoggedInUrl:"checkIfUserLoggedIn",
        getAllCountriesUrl:"getAllCountries",
        getRegionsByCountryUrl:"getRegionsByCountry",
        getCitiesByRegionsUrl:'getCitiesByRegions',
        loginAdminUrl:"loginAdmin",
        checkIfAdminLoggedInUrl:"checkIfAdminLoggedIn",
        getAllPackagesUrl:"getAllPackages",
        approvePackagesUrl:'approvePackages',
        uploadBannerImagesForPackageUrl:"uploadBannerImagesForPackage",
        getAllBannerImagesUrl:"getAllBannerImages",
        removeBannerImageUrl:'removeBannerImage',
        uploadImageForIternaryUrl:"uploadImageForIternary",
        getPackageIternaryImagesUrl:"getPackageIternaryImages",
        removeIternaryImageUrl:"removeIternaryImage",
        approveDissapprovePackagesUrl:"approveDissapprovePackages",
        registerNewQueryUrl:"registerNewQuery",
        getAllQueriesUrl:"getAllQueries",
        updateQueryRemarkUrl:"updateQueryRemark",
        mappQueryToNormalCustomerUrl:"mappQueryToNormalCustomer",
        getQueriesPreviousCustomersRoleWiseUrl:'getQueriesPreviousCustomersRoleWise',
        getQueryRemarksByQueryIdUrl:"getQueryRemarksByQueryId",
        createQueryNotesUrl:"createQueryNotes",
        updateQueryNotesUrl:"updateQueryNotes",
        getQueryNotesByQueryIdUrl:"getQueryNotesByQueryId",
        
        getAllPackagesByPortalIdUrl:"getAllPackagesByPortalId",
        
        
        registerCompanyConsumerDetailUrl:"registerCompanyConsumerDetail",
        updateCompanyConsumerDetailUrl:"updateCompanyConsumerDetail",
        getCompanyConsumerDetailIdUrl:"getCompanyConsumerDetail",
        getAllCompanyConsumerDetailUrl:"getAllCompanyConsumerDetail",
        deleteCompanyConsumerDetailUrl:"deleteCompanyConsumerDetail",
        searchAllCompanyUrl:"searchAllCompany",
        
        registerCustomerDetailsUrl:"registerCustomerDetail",
        updateCustomerDetailsUrl:"updateCustomerDetail",
        getAllCustomerDetailsUrl:"getAllCustomerDetail",
        getCustomerDetailsByIdUrl:"getCustomerDetailsById",
        deleteCustomerDetailsUrl:"deleteCustomerDetail",

        getAllContinentesUrl:"getAllContinentes",
        getCountriesByContinentCodeUrl:"getCountriesByContinentCode",
        getAirportsByCountryCodeUrl:"getAirportsByCountryCode",
        
        createOfferUrl:"createOffer",
        uploadImageFilesUrl:"uploadImageFiles",
        getAllOffersByAdminUrl:"getAllOffersByAdmin",
        getAllOffersCustomerUrl:"getAllOffersCustomer",
        getOffersDetailsBytitleUrl:"getOffersDetailsBytitle",
        updateOffersUrl:"updateOffers",
        deleteOfferurl:"deleteOffer",
        approveDissapproveOffersUrl:"approveDissapproveOffers",
        getAllOfferPublicUrl:"getAllOfferPublic",
        getOffergeDetailsByOfferIdUrl:"getOffergeDetailsByOfferId",
        approveOffersUrl:"approveOffers",


        /******* Headers ********/
        authToken: "authToken",
        contentType: "Content-Type",
        invitationCode: "invitationCode",
        SALES:1,
        OPHEAD:4,
        OPERATION:2,

        /****** Models *******/


        /*Authentication Token*/
        authenticationToken: "authenticationToken",

        /*Base Service Response*/
        operationStatus: "operationStatus",
        resultSet: "resultSet",
        
        /*Customer*/
        sessionToken:"sessionToken",
        id:"id",
        title: "title",
        firstName: "firstName",
        middleName: "middleName",
        lastName: "lastName",
        dateOfBirth: "dateOfBirth",
        companyName: "companyName",
        designation: "designation",
        businessAddress: "businessAddress",
        telNo: "telNo",
        emailId: "emailId",
        homeAddress: "homeAddress",
        passPortNo: "passPortNo",
        passportDateOfIssue: "passportDateOfIssue",
        passportDateOfExpriry: "passportDateOfExpriry",
        spouseName: "spouseName",
        spouseBirthDate: "spouseBirthDate",
        weddingAnniversary: "weddingAnniversary",
        spousePassportNo: "spousePassportNo",
        spousePassportDateOfIssue: "spousePassportDateOfIssue",
        spousePassportDateOfExpiry: "spousePassportDateOfExpiry",
        spouseContactNo: "spouseContactNo",
        spouseEmail: "spouseEmail",
        gstinNo: "gstinNo",
        handicap: "handicap",
        seartchString:"seartchString",
        customerId:"customerId",
        customerVisas:"customerVisas",
        customerFrequentFlyers:"customerFrequentFlyers",
        customerInterest:"customerInterest",
        searchData:"searchData",
        reference:"reference",
        username:"username",
        password:"password",
        name:"name",
        mobileNumber:"mobileNumber",
        customers:"customers",
        customerRolesMappings:"customerRolesMappings",
        roleId:"roleId",
        roleType:"roleType",
        
        /*company and consumers details*/
        AppCompanyConsumerDetails : "appCompanyConsumerDetails",
        AppCustomerDetails : "appCustomerDetails",
        location:"location",
        grade:"grade",
        department:"department",
        category:"category",
        companyId:"companyId",
        userId:"userId",
        
        /*Countries*/ 
        continentName:"continentName",
        fullName:"fullName",
        iso3:"iso3",
        continentCode:"continentCode",
        countryCode:"countryCode",
        


        /** Enquiry */
        guestName:"guestName",
        contactNo:"contactNo",
        serviceId:"serviceId",
        serviceName:"serviceName",
        destinationTypeId:"destinationTypeId",
        destinationTypeName:"destinationTypeName",
        visaTypeId:"visaTypeId",
        visaTypeName:"visaTypeName",
        sector:'sector',
        dateOfTravel:"dateOfTravel",
        adult:"adult",
        child:"child",
        oneWayJourney:"oneWayJourney",
        returnJourney:"returnJourney",
        journeyFrom:"journeyFrom",
        journeyTo:"journeyTo",
        status:"status",
        log:"log",
        remark:"remark",
        enquiryId:"enquiryId",
        createdBy:"createdBy",
        journeyType:"journeyType",
        departureDate:'departureDate',
        returnDate:"returnDate",
        infants:"infants",
        fromAirportAppId:"fromAirportAppId",
        fromAirportCode:"fromAirportCode",
        fromAirportCity:"fromAirportCity",
        fromAirportName:"fromAirportName",
        toAirportAppId:"toAirportAppId",
        toAirportCode:"toAirportCode",
        toAirportCity:"toAirportCity",
        toAirportName:"toAirportName",
        enquiries:"enquiries",
        airTicketMappings:'airTicketMappings',
        visaCountry:"visaCountry",
        countryId:"countryId",
        holidayFromCity:"holidayFromCity",
        holidayToCity:"holidayToCity",
        holidayFromCountry:"holidayFromCountry",
        holidayToCountry:"holidayToCountry",
        rooms:"rooms",
        checkIn:"checkIn",
        checkOut:"checkOut",
        country:"country",
        city:"city",
        enquiryToHotelMappings:"enquiryToHotelMappings",
        dateOfNextAction:"dateOfNextAction",

        fromContinentsName:"fromContinentsName",
        fromCountryName:"fromCountryName",
        toContinentsName:"toContinentsName",
        toCountryName:"toCountryName",

        /*MultiAirtiCket*/ 
        fromContinentName:"fromContinentName",
        toContinentsName:"toContinentName",


        /*Consumer*/
        consumer:"consumer",
        consumerInterest:"consumerInterest",
        consumerFrequentFlyers:"consumerFrequentFlyers",
        consumerVisas:"consumerVisas",

        /* Package */
        id:"id",
        name:"name",
        title:"title",
        banner_image:"banner_image",
        night:"night",
        days:"days",
        listingDetails:"listingDetails",
        inclusion:"inclusion",
        exlusion:"exlusion",
        validity:"validity",
        seoTitle:"seoTitle",
        seoDescri:"seoDescri",
        seoKeywords:"seoKeywords",
        packageNo:"packageNo",
        categoryId:"categoryId",
        emailId:"emailId",
        password:"password",
        packageId:"packageId",
        regionId:"regionId",
        continent:"continent",
        
        /*-Offers-*/
        imgUrl:"imgUrl",
        offerDetails:"offerDetails",


        /* iternary */
        dayFromTimeSlot:"dayFromTimeSlot",
        dayToTimeSlot:"dayToTimeSlot",
        dayNumber:"dayNumber",
        dayDate:"dayDate",
        packageId:"packageId",
        packageName:"packageName",
        dayImage:"dayImage",
        slotDetails:"slotDetails",
        fromTimeUniqueId:"fromTimeUniqueId",
		toTimeUniqueId:"toTimeUniqueId",
        iternaryDetailsUniqueId:"iternaryDetailsUniqueId",
        country:"country",
        city:"city",
        region:"region",
        imageId:"imageId",
        iternaryId:"iternaryId",


         /*File*/
         fileContent: "file",
         fileId: "appFileId",
         files:"files",
         appFiles:"appFiles",
         fileName:"fileName",

         /*Query and Notes*/
         queryData:"queryData",
         appQueries:"appQueries",
         appQueriesRemarks:"appQueriesRemarks",
         appQueryNumber:"appQueryNumber",
         createdBy:"createdBy",
         queryNumber:"queryNumber",
         queryId:"queryId",
         remark:"remark",
         nextActiondate:"nextActiondate",
         createdByName:"createdByName",
         appQueriesNotes:"appQueriesNotes",
    	 notesNumber:"notesNumber",
    	 notes:"notes",
    	 queriesFlag:"queriesFlag",
        
         /*Admin Portal Id*/
        portalId:"portalId",
        adminPortalId:"adminPortalId",
    
        
        //Models
        
        id:"id",
        emailId:"emailId",
        password:"password",
        name:"name",
        roomNo:"roomNo",
        roomType:"roomType",
        capacity:"capacity",

        sessionToken:"sessionToken",
        AdminId:"AdminId",
        userId:"userId",
        contactNo:"contactNo",
        checkInDate:"checkInDate",
        checkOutDate:"checkOutDate",
        avaibality:"avaibality"
        

        
    }
});