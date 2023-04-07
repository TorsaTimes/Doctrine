Class {
	#name : 'HfuEstimatedReceipt',
	#superclass : 'Object',
	#instVars : [
		'netAmount',
		'grossAmount',
		'positions',
		'path',
		'allLinesCollection',
		'allWordsCollection',
		'date',
		'name',
		'jsonPath',
		'mwst',
		'beginDate',
		'endDate',
		'foundTimeCollection',
		'foundDateCollection',
		'atime',
		'netWord',
		'grossWord',
		'mwstWord',
		'hasTwoTax',
		'mwstSeveWord',
		'mwstNineteenWord',
		'amountKeyword',
		'receiptAmountsCollection',
		'receiptAmountsCollectionInCent',
		'grossFromCalculateTax',
		'netAmountCollection',
		'grossAmountCollection',
		'keywordAmountCollection',
		'allTextractWordsCollection',
		'allTextractLinesCollection'
	],
	#classVars : [
		'ReceiptsCollection',
		'IsWordDateSet',
		'IsHotelSet',
		'IsDateSet',
		'IsAllKeyWordDictionary',
		'Receipts',
		'IsGrossWordDictionary',
		'IsKeyWordDictionary',
		'IsTimeSet',
		'IsNetWordDictionary'
	],
	#category : 'HfuReceiptRecognitionApp'
}

{ #category : 'Not categorized' }
HfuEstimatedReceipt class >> fillAllKeyWordDictionary [

	 HfuEstimatedReceipt isAllKeyWordDictionary:(Dictionary new
	 at: 1 put: 'Summe';
	 at: 2 put: 'Betrag';
	 at: 3 put: 'Gesamtbetrag';
	 at: 4 put: 'Bar';
	 at: 5 put: 'Gesamt';
	 at: 6 put: 'Brutto';
	 at: 7 put: 'EUR';
	 at: 8 put: 'Zwischensumme';
	 at: 9 put: 'Gesamt-Brutto';
	 at: 10 put: 'SUMME EUR';
	 at: 11 put: 'Total';
	 at: 12 put: 'Summe EURO';
	 at: 13 put: 'Barzahlung';
	 at: 14 put: 'GESAMT BRUTTO';
	 at: 15 put: 'zu zahlen';
	 at: 16 put: 'GESAMT:';
	 at: 17 put: 'Gesamtpreis';
	 at: 18 put: 'Rechnungsbetrag EUR';
	 at: 19 put: 'BAR';
	 at: 29 put: 'Betrag EUR';
	 at: 30 put: 'Belegsumme';
	 at: 31 put: 'EURO';
	 at: 32 put: 'zu';
	 at: 33 put: 'zahlen';
	 at: 34 put: 'zu zahlen';
	 at: 35 put: '(brutto):';
	 at: 36 put: 'Gesamtbetrag (brutto):';
	 at: 37 put: '(brutto)';
	 at: 38 put: '(netto)';
	 at: 39 put: '(netto):';
	 at: 40 put: 'Gesamtbetrag:';
	 at: 41 put: '(brutto):';
	 at: 42 put: 'Sumne';
	 at: 43 put: 'Nettobetrag:';
	 at: 44 put: 'Nettobetrag';
	 at: 45 put: 'Netto';
	 at: 46 put: 'Sunne';
	 at: 47 put: 'Sunme';
	 at: 48 put: 'SUMME';
	 at: 49 put: 'Bruttobetrag';
	 at: 50 put: 'Bruttobetrag:';
	 at: 51 put: 'Endsumme';
	 at: 52 put: 'BRUTTO';
	 at: 53 put: 'BETRAG';
	 at: 54 put: 'Neto';
	 at: 55 put: 'Nitto';
	 at: 56 put: 'Rechnungsbetrag EUR';
	 at: 57 put: 'Gesantbetra}';
	 at: 58 put: 'Betrag EUR';
	 at: 59 put: 'Belegsumme';
	 at: 60 put: 'EURO';
	 at: 61 put: 'Netto-Entgelt';
	 at: 62 put: 'NETTO-Entgelt';
	 at: 63 put: 'Nettoumsatz';
	 at: 64 put: 'Totalbetrag:';
	 at: 65 put: 'Totalbetrag';
	 at: 66 put: 'NETTO';
	 at: 67 put: 'NET';
	 at: 68 put: 'Net';
	 at: 69 put: 'Totalbetrag:';
	 at: 70 put: 'Totalbetrag';
	 at: 71 put: 'Total:';
	 at: 72 put: 'ZWISCHENSUMME:';
	 at: 73 put: 'Tota';
	 at: 74 put: 'NETIO-Entgelt';
	 at: 75 put: 'Gesantbetra';
	 at: 76 put: 'Mwst';
	 at: 77 put: 'Gesamtbetra';
	 at: 78 put: 'ZW-SUMME';
	 at: 79 put: 'Gesamtbetra';
	 at: 80 put: 'SuImme';
	yourself).
]

{ #category : 'Not categorized' }
HfuEstimatedReceipt class >> fillDateSet [

self isDateSet: (Set new
add: '##.##.##';
add: '##.##.####*';
add: '##.#.####*';
add: '#.#.####*';
add: '#.#.##';
add: '##/##/####*';
add: '####/#/#*';
add: '####/#/##*';
add: '####/##/#*';
add: '####/##/##*';
add: '####-##-##*';
add: '##.###.#####';
"add: '*January*';
add: '*February*';
add: '*March*';
add: '*April*';
add: '*May*';
add: '*June*';
add: '*July*';
add: '*August*';
add: '*September*';
add: '*October*';
add: '*November*';
add: '*December*';"
yourself).


]

{ #category : 'Not categorized' }
HfuEstimatedReceipt class >> fillGrossWordDictionary [
	
	
	HfuEstimatedReceipt isGrossWordDictionary:(Dictionary new
	 at: 1 put: 'brutto';
	 at: 2 put: 'Bruttobetrag';
	 at: 3 put: 'Brutto-Entgeld';
	 at: 5 put: 'Brutto';
	 at: 6 put: 'brutto:';
	 at: 7 put: '(brutto)';
	 at: 8 put: '(brutto):';
	 at: 9 put: 'BRUTTO';
	 at: 10 put: 'Brutto-Summe';
	 at: 14 put: 'Brutto:';
	 at: 15 put: 'Bruto:';
	 at: 16 put: 'Brutto';
	 at: 17 put: 'bruto';
	 at: 18 put: 'bruttto';
	 at: 19 put: 'Bruttto';
	 at: 20 put: 'brtto';
	 at: 21 put: 'Bruttobetrag';
	 at: 22 put: 'Bruttobetrag:';
	 at: 23 put: 'BRUTTO';
	yourself).


]

{ #category : 'Not categorized' }
HfuEstimatedReceipt class >> fillIsHotelSet [

HfuEstimatedReceipt isHotelSet:( Set new 
add: 'Hotel';
add: 'Motel';
add: '*hotel';
add: 'Hotel*'; 
add: 'H0tel';"Schreibfehler Null an 2ter Stelle"
add: 'HoteI';"Schreibfehler i am Ende"
add: 'Hote1' ;"Schreibfehler 1 am Ende"
add: 'Inn';
add: 'lnn';"Schreibfehler l am Anfang"
add: '1nn';"Schreibfehler 1 am Anfang"
add: 'Im';"Schreibfehler m statt nn ?"
add:'Bed * Breakfast' ;""
add:'Appartment*' ;
add:'Apartment*' ;
add: 'Pension';
add: 'Hostel';
add: 'Guest Room';
add: 'Gasthof';
"Ketten:"
add: 'A&O Hotels and Hostels';
add: 'Abode';
add: 'Accor Hotels';
add: 'Achat';
add: 'Adagio';
add: 'Adina Apartment Hotels';
add: 'Advena';
add: 'Airbnb';
add: 'Akzent Hotels ';
add: 'aloft Hotels';
add: 'Althoff';
add: 'Amedia';
add: 'Ameron';
add: 'Apex';
add: 'Apollo';
add: 'Arcadia Hotels';
add: 'Arcotel';
add: 'Arvena';
add: 'Ascot';
add: 'Autograph Collection';
add: 'Azimut';
add: 'B&B Hotels';
add: 'Balladins';
add: 'BarcelHotels';
add: 'Bastion';
add: 'Best Western';
add: 'BlueBay Hotels & Resorts';
add: 'Britannia';
add: 'Campanile';
add: 'Capri by Fraser';
add: 'Center Parcs';
add: 'Citadines';
add: 'CityClass Hotels';
add: 'Clarion';
add: 'Comfort';
add: 'Concorde';
add: 'Conrad';
add: 'Copthorne';
add: 'Country Inn';
add: 'Courtyard';
add: 'CPH Hotels';
add: ' Crossland Economy Studios';
add: 'Crowne Plaza';
add: 'Days Inn';
add: 'Derag Hotels';
add: 'Dorint';
add: 'Dreamhouse Apartments';
add: 'easyHotel';
add: 'Europa Group Hotels';
add: 'Eurostars Hotels ';
add: 'Fairmont';
add: 'Flair';
add: 'Flemings';
add:'Floris';
add:'Four Points by Sheraton';
add:'Geisel Privathotels';
add:'GHotel';
add:'Golden Leaf';
add:'Golden Tulip';
add:'Grand Hyatt';
add:'Greenline';
add:'Guldsmeden';
add:'Schwaennewig';
add:'H & Hotels';
add:'H10 Hotels';
add:'Hampshire';
add:'Hampton by Hilton';
add:'Helnan';
add:'Hilton Garden Inn';
add:'Hilton Hotels';
add:'Hilton, Waldorf Astoria Collection';
add:'Holiday Inn';
add:'Holiday Inn Express';
add:'Hotel du Vin';
add:'Hotusa Hotels';
add:'Hyatt Hotels';
add:'ibis';
add:'ibis budget';
add:'ibis Styles';
add:'IFA Hotels & Resorts';
add:'Indigo';
add:'Innside';
add:'InterCityHotel';
add:'InterContinental';
add:'Kempinski';
add:'Land-gut-Hotels';
add:'Landidyll';
add:'Le Meridien Hotels & Resorts';
add:'Leonardo Hotels';
add:'Lindner';
add:'Logis International';
add:'Mandarin Oriental';
add:'Maritim';
add:'Mark Hotels';
add:'Marriott';
add:'mD-Hotels';
add:'Meininger';
add:'Mercure';
add:'MGallery';
add:'Millennium';
add:'Minotel';
add:'Modena by Fraser';
add:'Montana';
add:'Motel One';
add:'nestor Hotels & acomhotels';
add:'NH Hotel Group';
add:'Nhow';
add:'Nikko Hotels International';
add:'Novotel';
add:'Novum';
add:'Park Hyatt';
add:'Park Inn by Radisson';
add:'Park Plaza';
add:'Penta Hotels';
add:'Postillion Hotels';
add:'Preferred Hotels & Resorts';
add:'Premier Inn';
add:'PremiumClasse';
add:'Pullman';
add:'Quality';
add:'Radisson Blu';
add:'Ramada';
add:'Regent';
add:'Reikartz';
add:'Relais & Chateaux';
add:'Relais du Silence';
add:'Relexa';
add:'Renaissance';
add:'Ringhotels';
add:'Robinson Club';
add:'Rocco Forte';
add:'Romantik';
add:'Sana Hotels';
add:'Scandic';
add:'Seaside';
add:'Sheraton';
add:'Sleep Inn';
add:'Sofitel';
add:'Sorat';
add:'Star Inn';
add:'Steigenberger Hotel Group';
add:'Suite Novotel';
add:'Super 8';
add:'Swiss Quality Hotels';
add:'Swissadd:';
add:'The Luxury Collection';
add:'The Ritz-Carlton';
add:'TOP Hotel';
add:'Toyoko Inn';
add:'Travel Charme';
add:'Tryp';
add:'Tulip Inn';
add:'Upstalsboom Hotels und Ferienwohnungen';
add:'Van der Valk';
add:'VCH-Hotels';
add:'Welcome';
add:'Westin';
add:'Winter*s';
add:'Worldhotels';
add:'Wyndham Hotels & Resorts ';
add:'Zleep';
add:'Logis';
add:'Einzelzimmer';
add:'Doppelzimmer';
add:'Aufenthaltsdauer';
add:'Parkplatz';
yourself).

]

{ #category : 'Not categorized' }
HfuEstimatedReceipt class >> fillKeyWordDictionary [

	HfuEstimatedReceipt isKeyWordDictionary:(Dictionary new
	 at: 1 put: 'Summe';
	 at: 2 put: 'Betrag';
	 at: 3 put: 'Gesamtbetrag';
	 at: 4 put: 'Bar';
	 at: 5 put: 'Gesamt';
	 at: 8 put: 'Zwischensumme';
	 at: 9 put: 'Gesamt-Brutto';
	 at: 10 put: 'SUMME EUR';
	 at: 11 put: 'Total';
	 at: 12 put: 'Summe EURO';
	 at: 13 put: 'Barzahlung';
	 at: 14 put: 'GESAMT BRUTTO';
	 at: 15 put: 'zu zahlen';
	 at: 16 put: 'GESAMT:';
	 at: 17 put: 'Gesamtpreis';
	 at: 18 put: 'Rechnungsbetrag EUR';
	 at: 19 put: 'BAR';
	 at: 29 put: 'Betrag EUR';
	 at: 30 put: 'Belegsumme';
	 at: 31 put: 'EURO';
	 at: 32 put: 'zu';
	 at: 33 put: 'zahlen';
	 at: 34 put: 'zu zahlen';
	 at: 35 put: 'Gesamtbetrag (brutto):';
	 at: 36 put: 'Gesamtbetrag:';
	 at: 37 put: 'Sumne';
	 at: 38 put: 'Sunne';
	 at: 39 put: 'Sunme';
	 at: 40 put: 'SUMME';
	 at: 41 put: 'Endsumme';
	 at: 42 put: 'BETRAG';
	 at: 43 put: 'Rechnungsbetrag EUR';
	 at: 44 put: 'BAR';
	 at: 45 put: 'Betrag EUR';
	 at: 46 put: 'Belegsumme';
	 at: 47 put: 'EURO';
	 at: 48 put: 'Gesantbetra}';
	 at: 49 put: 'Gesantbetrag';
	 at: 50 put: 'Totalbetrag:';
	 at: 51 put: 'Totalbetrag';
	 at: 52 put: 'Total:';
	 at: 53 put: 'ZWISCHENSUMME:';
	 at: 54 put: 'Tota';
	 at: 55 put: 'Gesantbetra';
	 at: 56 put: 'Preis';
	 at: 57 put: 'GESAMTRECHNUNGSBETRAG';
	 at: 58 put: 'GESAMTZAHLUNG';
	 at: 59 put: '(EUR)';
	 at: 60 put: 'SuImme';
	 at: 61 put: 'Mwst';
	 yourself).
]

{ #category : 'Not categorized' }
HfuEstimatedReceipt class >> fillNetWordDictionary [

		HfuEstimatedReceipt isNetWordDictionary:(Dictionary new
	 at: 1 put: 'netto';
	 at: 2 put: 'Nettobetrag';
	 at: 3 put: 'Netto-Entgeld';
	 at: 4 put: 'Subtotal';
	" at: 5 put: 'Gesamt';"
	 at: 6 put: 'Net';
	 at: 7 put: 'Netto';
	 at: 8 put: 'Netto:';
	 at: 9 put: '(netto)';
	 at: 10 put: '(netto):';
	 at: 11 put: 'netto:';
	 at: 12 put: 'Netto-Entgelt';
	 at: 13 put: 'NETTO';
	 at: 14 put: 'Nettobetrag:';
	 at: 15 put: 'Nettobetrag';
	 at: 16 put: 'Neto';
	 at: 17 put: 'Nitto';
	 at: 18 put: 'Nettoumsatz';
	 at: 19 put: 'NET';
	 at: 20 put: 'Net';
	 at: 21 put: 'NETIO-Entgelt';
	 at: 22 put: 'NETTO-Entgelt';
	 at: 23 put: '(Netto)';
	 yourself).
]

{ #category : 'Not categorized' }
HfuEstimatedReceipt class >> fillReceiptCollectionWithOneReceipt: aPath index: aIndex aChar: aChar [

	| aReceiptResponseObject aReceiptCollection |

		HfuEstimatedReceipt fillTimeSet.
		IsTimeSet:=HfuEstimatedReceipt isTimeSet.
		aReceiptCollection := OrderedCollection new.
		HfuEstimatedReceipt receipts: OrderedCollection new.
		HfuEstimatedReceipt fillDateSet.
		HfuEstimatedReceipt fillWordDateSet.
		IsDateSet:=HfuEstimatedReceipt isDateSet.
		IsWordDateSet := HfuEstimatedReceipt isWordDateSet.
		
		HfuEstimatedReceipt receiptsCollection: OrderedCollection new.
		HfuEstimatedReceipt fillIsHotelSet.
		IsHotelSet:=HfuEstimatedReceipt isHotelSet.
		aIndex to: aIndex do: [ :eachNumber | 
		aReceiptResponseObject := ClwTextractHelper analyzeImage: (aPath , '\' , (aChar) asString , (eachNumber padWithZerosDesiredSize: 3) asString, '.png') withCache: true. 
		aReceiptCollection add: aReceiptResponseObject.].
		
		HfuEstimatedReceipt receipts addCollection:  aReceiptCollection.
		
		HfuEstimatedReceipt receipts doWithIndex:[:eachRowReceipt :index | | aReceipt | aReceipt := HfuEstimatedReceipt new. aReceipt scanReceipt: index name:  ((aChar) asString, (aIndex padWithZerosDesiredSize: 3) asString, '.png').
								HfuEstimatedReceipt receiptsCollection add:  aReceipt.
								].
								
		HfuEstimatedReceipt  writeCSVClassMethodOneReceipt.
]

{ #category : 'Not categorized',
  #vaVisibility : 'private' }
HfuEstimatedReceipt class >> fillReceiptsCollection [

	
	1 to: 100 do: [ :eachNumber | ].
]

{ #category : 'Not categorized' }
HfuEstimatedReceipt class >> fillReceiptsCollection: aPath index: aIndex char: aChar [

	| aReceiptResponseObject aReceiptCollection |
	
		HfuEstimatedReceipt fillTimeSet.
		IsTimeSet:=HfuEstimatedReceipt isTimeSet.
		aReceiptCollection := OrderedCollection new.
		HfuEstimatedReceipt receipts: OrderedCollection new.
		HfuEstimatedReceipt fillDateSet.
		HfuEstimatedReceipt fillWordDateSet.
		IsDateSet:=HfuEstimatedReceipt isDateSet.
		IsWordDateSet := HfuEstimatedReceipt isWordDateSet.
		
		HfuEstimatedReceipt receiptsCollection: OrderedCollection new.
		HfuEstimatedReceipt fillIsHotelSet.
		IsHotelSet:=HfuEstimatedReceipt isHotelSet.
	1 to: aIndex do: [ :eachNumber | 
		aReceiptResponseObject := ClwTextractHelper analyzeImage: (aPath , '\' , (aChar) asString , (eachNumber padWithZerosDesiredSize: 3) asString, '.png') withCache: true. 
		aReceiptCollection add: aReceiptResponseObject.].
		
		HfuEstimatedReceipt receipts addCollection:  aReceiptCollection.
		
		HfuEstimatedReceipt receipts doWithIndex:[:eachRowReceipt :index | | aReceipt | aReceipt := HfuEstimatedReceipt new. aReceipt scanReceipt: index name:  ((aChar) asString, (index padWithZerosDesiredSize: 3) asString, '.png').
								HfuEstimatedReceipt receiptsCollection add:  aReceipt.
								].
								
		HfuEstimatedReceipt  writeCSVClassMethod.
]

{ #category : 'Not categorized' }
HfuEstimatedReceipt class >> fillReceiptsCollectionBeginEnd: aPath beginIndex: abeginIndex endIndex: aEndIndex aChar: aChar [

	| aReceiptResponseObject aReceiptCollection |

		HfuEstimatedReceipt fillTimeSet.
		IsTimeSet:=HfuEstimatedReceipt isTimeSet.
		aReceiptCollection := OrderedCollection new.
		HfuEstimatedReceipt receipts: OrderedCollection new.
		HfuEstimatedReceipt fillDateSet.
		HfuEstimatedReceipt fillWordDateSet.
		IsDateSet:=HfuEstimatedReceipt isDateSet.
		IsWordDateSet := HfuEstimatedReceipt isWordDateSet.
		
		HfuEstimatedReceipt receiptsCollection: OrderedCollection new.
		HfuEstimatedReceipt fillIsHotelSet.
		IsHotelSet:=HfuEstimatedReceipt isHotelSet.
		abeginIndex to: aEndIndex do: [ :eachNumber | 
		aReceiptResponseObject := ClwTextractHelper analyzeImage: (aPath , '\' , (aChar) asString , (eachNumber padWithZerosDesiredSize: 3) asString, '.png') withCache: true. 
		aReceiptCollection add: aReceiptResponseObject.].
		
		HfuEstimatedReceipt receipts addCollection:  aReceiptCollection.
		
		HfuEstimatedReceipt receipts doWithIndex:[:eachRowReceipt :index | | aReceipt | aReceipt := HfuEstimatedReceipt new. aReceipt scanReceipt: index name:  ((aChar) asString, (index padWithZerosDesiredSize: 3) asString, '.png').
								HfuEstimatedReceipt receiptsCollection add:  aReceipt.
								].
								
		"Receipt  writeCSVClassMethod."
]

{ #category : 'Not categorized' }
HfuEstimatedReceipt class >> fillTimeSet [

self isTimeSet: (Set new 
add: '##:##:##';
add: '##:##';
add: '##:## ##';
add: '#:## ##';
yourself).
]

{ #category : 'Not categorized' }
HfuEstimatedReceipt class >> fillWordDateSet [

self isWordDateSet: (Set new 
add: 'January';
add: 'February';
add: 'March';
add: 'April';
add: 'May';
add: 'June';
add: 'July';
add: 'August';
add: 'September';
add: 'October';
add: 'November';
add: 'December';
yourself).
"Ab hier kommen die ausgeschriebenen Monate"
"add: '### ##, ####';
add: '#### ##, ####';
add: '##### ##, ####';
add: '###### ##, ####';
add: '####### ##, ####';
add: '######## ##, ####';
add: '######### ##, ####';"

"yourself)."
]

{ #category : 'Not categorized' }
HfuEstimatedReceipt class >> isAllKeyWordDictionary [

	^IsAllKeyWordDictionary
]

{ #category : 'Not categorized' }
HfuEstimatedReceipt class >> isAllKeyWordDictionary: anObject [

	IsAllKeyWordDictionary := anObject
]

{ #category : 'Not categorized' }
HfuEstimatedReceipt class >> isDateSet [

	^IsDateSet
]

{ #category : 'Not categorized' }
HfuEstimatedReceipt class >> isDateSet: anObject [

	IsDateSet := anObject
]

{ #category : 'Not categorized' }
HfuEstimatedReceipt class >> isGrossWordDictionary [

	^IsGrossWordDictionary
]

{ #category : 'Not categorized' }
HfuEstimatedReceipt class >> isGrossWordDictionary: anObject [

	IsGrossWordDictionary := anObject
]

{ #category : 'Not categorized' }
HfuEstimatedReceipt class >> isHotelSet [

	^IsHotelSet
]

{ #category : 'Not categorized' }
HfuEstimatedReceipt class >> isHotelSet: anObject [

	IsHotelSet := anObject
]

{ #category : 'Not categorized' }
HfuEstimatedReceipt class >> isKeyWordDictionary [

	^IsKeyWordDictionary
]

{ #category : 'Not categorized' }
HfuEstimatedReceipt class >> isKeyWordDictionary: anObject [

	IsKeyWordDictionary := anObject
]

{ #category : 'Not categorized' }
HfuEstimatedReceipt class >> isNetWordDictionary [

	^IsNetWordDictionary
]

{ #category : 'Not categorized' }
HfuEstimatedReceipt class >> isNetWordDictionary: anObject [

	IsNetWordDictionary := anObject
]

{ #category : 'Not categorized' }
HfuEstimatedReceipt class >> isTimeSet [

	^IsTimeSet
]

{ #category : 'Not categorized' }
HfuEstimatedReceipt class >> isTimeSet: anObject [

	IsTimeSet := anObject
]

{ #category : 'Not categorized' }
HfuEstimatedReceipt class >> isWordDateSet [

	^IsWordDateSet
]

{ #category : 'Not categorized' }
HfuEstimatedReceipt class >> isWordDateSet: anObject [

	IsWordDateSet := anObject
]

{ #category : 'Not categorized' }
HfuEstimatedReceipt class >> receipts [

	^Receipts
]

{ #category : 'Not categorized' }
HfuEstimatedReceipt class >> receipts: anObject [

	Receipts := anObject
]

{ #category : 'Not categorized' }
HfuEstimatedReceipt class >> receiptsCollection [

	^ReceiptsCollection
]

{ #category : 'Not categorized' }
HfuEstimatedReceipt class >> receiptsCollection: anObject [

	ReceiptsCollection := anObject
]

{ #category : 'Not categorized' }
HfuEstimatedReceipt class >> writeCSVClassMethod [
"fileName;isHotel;date;time;totalGrossAmount;totalNetAmount;beginDate;endDate;positions;taxAmount
a001.png;true;01.02.2019;18:58:00;36,65;28,23;01.02.2019;05.02.2019;;
a002.png;true;01.02.2019;18:58:00;36,65;28,23;01.02.2019;05.02.2019;;
a003.png;true;01.02.2019;18:58:00;36,65;28,23;01.02.2019;05.02.2019;;
a004.png;true;01.02.2019;18:58:00;36,65;28,23;01.02.2019;05.02.2019;;"


	"sets the Class Variable Persons to the values of an Ordered Collection"
|theFileStream|


theFileStream := CfsWriteFileStream openEmpty: 'workerSaved.csv'.

theFileStream nextPutAll: 'fileName;isHotel;date;time;totalGrossAmount;totalNetAmount;beginDate;endDate;positions;taxAmount'.
	 theFileStream newLine;
	yourself.
															   


				HfuEstimatedReceipt receiptsCollection do:[:eachReceipts |  (theFileStream 
																nextPutAll: eachReceipts name;
																nextPutAll:';';
																nextPutAll: eachReceipts isHotelKeyWordSet asString;
																nextPutAll:';';
																nextPutAll: (((eachReceipts date) isNil) ifFalse:[eachReceipts date printStringDDDotMMDotYYYY]);
																nextPutAll:';';
																nextPutAll: (eachReceipts atime) asString;
																nextPutAll:';';
																nextPutAll: (eachReceipts grossAmount) ;
																nextPutAll:';';
																nextPutAll: (eachReceipts netAmount); 
																nextPutAll:';';
																nextPutAll: (((eachReceipts beginDate) isNil) ifFalse:[eachReceipts beginDate printStringDDDotMMDotYYYY]);
																nextPutAll:';';
																nextPutAll: (((eachReceipts endDate) isNil) ifFalse:[eachReceipts endDate printStringDDDotMMDotYYYY]);
																nextPutAll:';';
																nextPutAll: (eachReceipts positions) asString;
																nextPutAll:';';
																nextPutAll:(eachReceipts mwst);
																newLine;
																yourself).
																].
									theFileStream flush.
									theFileStream close.


]

{ #category : 'Not categorized' }
HfuEstimatedReceipt class >> writeCSVClassMethodOneReceipt [
"fileName;isHotel;date;time;totalGrossAmount;totalNetAmount;beginDate;endDate;positions;taxAmount
a001.png;true;01.02.2019;18:58:00;36,65;28,23;01.02.2019;05.02.2019;;
a002.png;true;01.02.2019;18:58:00;36,65;28,23;01.02.2019;05.02.2019;;
a003.png;true;01.02.2019;18:58:00;36,65;28,23;01.02.2019;05.02.2019;;
a004.png;true;01.02.2019;18:58:00;36,65;28,23;01.02.2019;05.02.2019;;"


	"sets the Class Variable Persons to the values of an Ordered Collection"
|theFileStream  |

theFileStream := CfsWriteFileStream openEmpty: 'workerSavedOne.csv'.

theFileStream nextPutAll: 'fileName;isHotel;date;time;totalGrossAmount;totalNetAmount;beginDate;endDate;positions;taxAmount'.
	 theFileStream newLine;
	yourself.
															   


				HfuEstimatedReceipt receiptsCollection do:[:eachReceipts |  (theFileStream 
																nextPutAll: eachReceipts name;
																nextPutAll:';';
																nextPutAll: eachReceipts isHotelKeyWordSet asString;
																nextPutAll:';';
																nextPutAll: (eachReceipts date) asString;
																nextPutAll:';';
																nextPutAll: (eachReceipts atime) asString;
																nextPutAll:';';
																nextPutAll: (eachReceipts grossAmount) ;
																nextPutAll:';';
																nextPutAll: (eachReceipts netAmount); 
																nextPutAll:';';
																nextPutAll:'';
																nextPutAll:';';
																nextPutAll:'';
																nextPutAll:';';
																nextPutAll:'';
																nextPutAll:';';
																nextPutAll:eachReceipts mwst  asString;
																newLine;
																yourself).
																
											
																
																].
									theFileStream flush.
									theFileStream close.
				

]

{ #category : 'API',
 #vaCategories : ['API','ScanReceipt'] }
HfuEstimatedReceipt >> allLinesCollection [

	^allLinesCollection
]

{ #category : 'API',
 #vaCategories : ['API','ScanReceipt'] }
HfuEstimatedReceipt >> allLinesCollection: anObject [

	allLinesCollection := anObject
]

{ #category : 'ScanReceipt' }
HfuEstimatedReceipt >> allTextractLinesCollection [

	^allTextractLinesCollection
]

{ #category : 'ScanReceipt' }
HfuEstimatedReceipt >> allTextractLinesCollection: anObject [

	allTextractLinesCollection := anObject
]

{ #category : 'ScanReceipt' }
HfuEstimatedReceipt >> allTextractWordsCollection [

	^allTextractWordsCollection
]

{ #category : 'ScanReceipt' }
HfuEstimatedReceipt >> allTextractWordsCollection: anObject [

	allTextractWordsCollection := anObject
]

{ #category : 'API',
 #vaCategories : ['API','ScanReceipt'] }
HfuEstimatedReceipt >> allWordsCollection [

	^allWordsCollection
]

{ #category : 'API',
 #vaCategories : ['API','ScanReceipt'] }
HfuEstimatedReceipt >> allWordsCollection: anObject [

	allWordsCollection := anObject
]

{ #category : 'API',
 #vaCategories : ['API','FilterAmounts'] }
HfuEstimatedReceipt >> amountKeyword [

	^amountKeyword
]

{ #category : 'API',
 #vaCategories : ['API','FilterAmounts'] }
HfuEstimatedReceipt >> amountKeyword: anObject [

	amountKeyword := anObject
]

{ #category : 'Positions' }
HfuEstimatedReceipt >> amountOfPositions [

	|matchPatternCollection allLinesCounter aBoolean positionCounter aOrderedCollection copySortedCollection aCollection startConditionMatchKeyWordCollection endConditionMatchKeyWordCollection counterConditionSatisfied|
	
	positionCounter := 0.
	allLinesCounter := 0.
		
	matchPatternCollection := (OrderedCollection new
	add: '*#,##';
	add: '*#.##';
	yourself).
	
	endConditionMatchKeyWordCollection := (OrderedCollection new
	add: '*gesamt#';
	add: '*gesamt';
	add: 'gesamt*';
	add: 'total';
	add: 'total#';
	add: 'summe#';
	add: 'summe';
	add:'*summe';
	add: 'bar';
	yourself).
	
	
	"startConditionMatchKeyWordCollection := (OrderedCollection new
	add: '*price';
	add: 'price*';
	add: '*preis';
	add: '*preis#';
	add: '*rechnung*';
	add: '*betrag';
	add: 'tel*';
	add: '*betrag';
	yourself)."
	
	"(if start condition fullfilled && Collection not Empty)
		(if endCondition fulllfilled )
			aboolean = false."
	
	aOrderedCollection := OrderedCollection new.
	"aBoolean := true."
	
"	self allTextractLinesCollection doWithIndex: [:eachSortedCollection :index| 
		allLinesCounter := allLinesCounter +1.
		eachSortedCollection do:[:eachTextractBlock | 
		endConditionMatchKeyWordCollection do:[:eachWord |
		(eachWord match: eachTextractBlock text)
		ifFalse:[
		]
		ifTrue:[
		].].].].].
	"
	self allTextractLinesCollection do: [:eachSortedCollection| 
	matchPatternCollection do:[:eachPattern | 
	 (eachPattern match:  (eachSortedCollection at: eachSortedCollection size) text)
		ifTrue:[
		positionCounter := positionCounter +1.
		].
		"allLinesCounter := allLinesCounter -1.
		allLinesCounter = 0 
		ifTrue:[
		aBoolean := false.
		]."
		].].
	
	 self positions: (positionCounter).
	

	"self allTextractLinesCollection do:[:eachSortedCollection | 
	eachSortedCollection do:[:eachWord | eachWord match:
	].].
	"
	
" match: *,%%"
"Preis / preis"
]

{ #category : 'API',
 #vaCategories : ['API','CheckDate'] }
HfuEstimatedReceipt >> atime [

	^atime
]

{ #category : 'API',
 #vaCategories : ['API','CheckDate'] }
HfuEstimatedReceipt >> atime: anObject [

	atime := anObject
]

{ #category : 'API',
 #vaCategories : ['API','CheckDate'] }
HfuEstimatedReceipt >> beginDate [

	^beginDate
]

{ #category : 'API',
 #vaCategories : ['API','CheckDate'] }
HfuEstimatedReceipt >> beginDate: anObject [

	beginDate := anObject
]

{ #category : 'FilterAmounts' }
HfuEstimatedReceipt >> calculateTax [

		| aBoolean aSecondCollection |


		self receiptAmountsCollectionInCent do: [:eachAmount | 
			((eachAmount class) = HfuEstimatedReceipt )
			ifTrue: [			self receiptAmountsCollectionInCent remove: eachAmount.
]
		].

		aBoolean := true.
		aSecondCollection := OrderedCollection new.
		aSecondCollection := self keywordAmountCollection.
		"Itteriere durch jeden Betrag"
		(((((self receiptAmountsCollectionInCent) isEmpty) or:[(self receiptAmountsCollectionInCent size) <= 2]) or:[(self receiptAmountsCollection) isEmpty]) or:[(self receiptAmountsCollection size) <= 2])
		ifFalse:[
		(self receiptAmountsCollectionInCent) do:[:eachAmount |
		
		| aSevenAmount aNineTeenAmount centAmount|
		"Gibt den Cent amount von eachAmount"
		centAmount := (eachAmount) asNumber.
		"Berechne aus centAmount 7 und 19 Pozent hier bekommen wir dann den MWST Betrag"
		aSevenAmount := (((((centAmount asNumber)/107)*7) asFloat) rounded) integerPart.
		aNineTeenAmount := (((((centAmount asNumber)/119)*19) asFloat) rounded) integerPart.

			(((self receiptAmountsCollectionInCent) includes: aSevenAmount) and:[self mwstSeveWord isTrue])
			ifTrue:[
				"aSevenAmount ist in receiptAmountsCollectionInCent includiert? dann pruefe ob die Summe von aSevenAmount + beliebiger Betrag der Collection der receiptAmountsCollectionInCent enthalten ist"
				(self receiptAmountsCollectionInCent) do:[:eachCheckAmount | 
					|  sumCheckFilteredSeven |    	
					sumCheckFilteredSeven := (eachCheckAmount+ aSevenAmount ).
					((((self receiptAmountsCollectionInCent includes: sumCheckFilteredSeven) or:[(self keywordAmountCollection) includes: aSevenAmount]) and: [ eachCheckAmount ~= 0]) and:[aSevenAmount ~= 0])
					ifTrue: [	
										((self checkIfAmountInCollection: sumCheckFilteredSeven) and:[aBoolean isTrue])
										ifTrue:[self mwstSeveWord: ( (aSevenAmount / 100))asFloat.
													aBoolean := false]]]].

			((((self receiptAmountsCollectionInCent) includes: aNineTeenAmount) or:[ (self keywordAmountCollection) includes: aNineTeenAmount]) and:[self mwstNineteenWord isTrue ])
			ifTrue:[
				(self receiptAmountsCollectionInCent) do:[:eachCheckAmount1 | 
					|  sumCheckFilteredNineteen |            
					sumCheckFilteredNineteen := (eachCheckAmount1+ aNineTeenAmount).
					(((self receiptAmountsCollectionInCent includes: sumCheckFilteredNineteen)and: [ eachCheckAmount1 ~= 0]) and:[aNineTeenAmount ~= 0])
					ifTrue: [  
										((self checkIfAmountInCollection: sumCheckFilteredNineteen) and:[aBoolean isTrue])
										ifTrue:[self mwstNineteenWord: (aNineTeenAmount / 100) asFloat.
														aBoolean := false]]]].            
		]]
		ifTrue:[self grossFromCalculateTax: nil].
		
		
		
		
		
]

{ #category : 'FilterAmounts' }
HfuEstimatedReceipt >> calculateTaxAmount [

	| aAmountTupelDictionary nineteenAmountTupelCollection sevenAmountTupelCollection | 
	
	aAmountTupelDictionary := Dictionary new.
	sevenAmountTupelCollection := OrderedCollection new.
	nineteenAmountTupelCollection := OrderedCollection new.
	
	"Hat der Beleg 7 und 19 Prozen MWST?"
	(self hasTwoTax isTrue)
	ifTrue: [
		"Itteriere durch jeden Betrag"
		(self receiptAmountsCollectionInCent) doWithIndex:[:eachAmount :index |
		
		| aSevenAmount aNineTeenAmount centAmount|
		"Gibt den Cent amount von eachAmount"
	
			centAmount := eachAmount asString.
		
		"Berechne aus centAmount 7 und 19 Pozent hier bekommen wir dann den MWST Betrag"
		aSevenAmount := (((((centAmount asNumber)/107)*7) asFloat) rounded) integerPart.
		aNineTeenAmount := (((((centAmount asNumber)/119)*19) asFloat) rounded) integerPart.

			((self receiptAmountsCollectionInCent) includes: aSevenAmount)
			ifTrue:[
				"aSevenAmount ist in receiptAmountsCollectionInCent includiert? dann prueffe ob die Summe von aSevenAmount + beliebiger Betrag der Collection der receiptAmountsCollectionInCent enthalten ist"
				(self receiptAmountsCollectionInCent) do:[:eachCheckAmount | 
					|  sumCheckFilteredSeven |    
					
					sumCheckFilteredSeven := (eachCheckAmount+ aSevenAmount ).
				
					((((self receiptAmountsCollectionInCent includes: sumCheckFilteredSeven) and: [ eachCheckAmount ~= 0] ) and:[ aSevenAmount ~= eachCheckAmount]) and:[aSevenAmount ~= 0])
					ifTrue: [	
										(sevenAmountTupelCollection isEmpty)
										ifTrue:[ 
										sevenAmountTupelCollection := OrderedCollection new.
										sevenAmountTupelCollection add: sumCheckFilteredSeven.
										sevenAmountTupelCollection add: 7.
										aAmountTupelDictionary at: aSevenAmount put: sevenAmountTupelCollection.].
										
										((sevenAmountTupelCollection at: 1) >= sumCheckFilteredSeven)
										ifFalse:[
										sevenAmountTupelCollection := OrderedCollection new.
										sevenAmountTupelCollection add: sumCheckFilteredSeven.
										sevenAmountTupelCollection add: 7.
										aAmountTupelDictionary at: aSevenAmount put: sevenAmountTupelCollection.]
					]]].
			
			((self receiptAmountsCollectionInCent) includes: aNineTeenAmount)
			ifTrue:[
				(self receiptAmountsCollectionInCent) do:[:eachCheckAmount1 | 
					|  sumCheckFilteredNineteen |    
					
					sumCheckFilteredNineteen := (eachCheckAmount1+ aNineTeenAmount).
					
					((((self receiptAmountsCollectionInCent includes: sumCheckFilteredNineteen)and: [ eachCheckAmount1 ~= 0]) and:[ aNineTeenAmount ~= eachCheckAmount1]) and:[aNineTeenAmount ~= 0])
					ifTrue: [       
										(nineteenAmountTupelCollection isEmpty)
										ifTrue:[ 
										nineteenAmountTupelCollection := OrderedCollection new.
										nineteenAmountTupelCollection add: sumCheckFilteredNineteen.
										nineteenAmountTupelCollection add: 19.
										aAmountTupelDictionary at: aNineTeenAmount put: nineteenAmountTupelCollection].
										
										((nineteenAmountTupelCollection at: 1) >= sumCheckFilteredNineteen)
										ifFalse:[
										nineteenAmountTupelCollection := OrderedCollection new.
										nineteenAmountTupelCollection add: sumCheckFilteredNineteen.
										nineteenAmountTupelCollection add: 19.
										aAmountTupelDictionary at: aNineTeenAmount put: nineteenAmountTupelCollection]
					]]]].
					
					self mergeTaxAmountDictionary: aAmountTupelDictionary
					]
	ifFalse: [
	"Hat der Beleg 7 Prozen MWST?"
	(self mwstSeveWord isTrue)
	ifTrue: [self calculateTax].
	"Hat der Beleg 19 Prozen MWST?"
	(self mwstNineteenWord isTrue)
	ifTrue:[self calculateTax]].
	
]

{ #category : 'FilterAmounts' }
HfuEstimatedReceipt >> checkIfAmountInCollection: aAmount [
		
		| aGrossAmountCollectionInCent aKeywordAmountCollectionInCent aNetAmountCollectionInCent |
		
		aNetAmountCollectionInCent := OrderedCollection  new.
		aKeywordAmountCollectionInCent := OrderedCollection new.
		aGrossAmountCollectionInCent := OrderedCollection new.
		
		((self grossAmountCollection isEmpty) or:[self grossAmountCollection isNil])
		ifFalse:[aGrossAmountCollectionInCent := (self convertCollectionToCent: (self grossAmountCollection))]
		ifTrue:[(((self netAmountCollection isEmpty) or:[self netAmountCollection isNil]))
					ifFalse:[aNetAmountCollectionInCent := (self convertCollectionToCent: (self netAmountCollection)).
								aGrossAmountCollectionInCent := '']
					ifTrue:[(((self keywordAmountCollection isEmpty) or:[self keywordAmountCollection isNil]) or:[self amountKeyword isFalse])
								ifFalse:[aKeywordAmountCollectionInCent := (self convertCollectionToCent: (self keywordAmountCollection)).
											aGrossAmountCollectionInCent := ''.]
									 ifTrue:[aKeywordAmountCollectionInCent := '']]].
		
		((self keywordAmountCollection isEmpty) or:[self keywordAmountCollection isNil])
		ifFalse:[aKeywordAmountCollectionInCent := (self convertCollectionToCent: (self keywordAmountCollection))]
		ifTrue:[aKeywordAmountCollectionInCent := ''].
		
		((aGrossAmountCollectionInCent includes: aAmount) and:[(self grossWord isTrue) or:[(self amountKeyword isTrue)]])
		ifTrue:[self grossFromCalculateTax: aAmount.
				
					^true]
		ifFalse:[
					((aKeywordAmountCollectionInCent includes: aAmount) and:[(((self grossWord isTrue) or:[(self amountKeyword isTrue)]) or:[self netWord isTrue])])
					ifTrue:[self grossFromCalculateTax: aAmount.
				
								^true ]
					ifFalse:[((aNetAmountCollectionInCent includes: aAmount) and:[(self netWord isTrue) or:[(self amountKeyword isTrue)]])
								ifTrue:[self grossFromCalculateTax: aAmount.
							
								^true ]
								ifFalse:[^false]]].
											
											
											
											
											
											
]

{ #category : 'FilterAmounts' }
HfuEstimatedReceipt >> checkIsAmountFormat: aWord [

	"Hat das Word Buchstaben? return false"
	(aWord isNil)
	ifTrue:[^false].
	
	(((('*.##.*' match: aWord) or:[('*%*' match: aWord)]) or:[('*:*' match: aWord)]) or:[aWord hasAnyLetter])
	ifTrue: [^false]
	ifFalse:[ 	(((((((('*.##' match: (aWord)) 
								or:['#,##' match: (aWord)]) 
									or:['*,##' match: (aWord)])
										or:['#.##' match: (aWord)]) 
											or:['*,' match: aWord]) 
												or:['*.' match: aWord]) 
													or:['*.##//*' match: aWord]) "Sonderfall beleg 14a"
														or:['*.##//*' match: aWord]) "Sonderfall beleg 14a"
																		ifTrue:[^true]
																		ifFalse:[^false]].

	
	
	
]

{ #category : 'FilterAmounts' }
HfuEstimatedReceipt >> checkSouroundWords: aWord index: index [

	| min max  |

			min := index - 5.
			max := index + 5.

		min to: max do: [ :aNumber |
	 ((self allWordsCollection at: aNumber) hasAnyDigit)
	 ifTrue: [ 
	 ^true]].

	^false
	
	
]

{ #category : 'CheckDate' }
HfuEstimatedReceipt >> checkValidTime [
	| theSubStrings theNumberOfDoppelpunkte theHoursNumber theMinutesNumber theSecondsNumber checkedValidity forkBoolean|
	theNumberOfDoppelpunkte := 0.
	checkedValidity := false.
	forkBoolean := false.
	"Hier die Abfrage ob theNumberOfDoppelpunkte = 2 ist. Nur dann wird fortgesetzt"
	foundTimeCollection do: [ :eachCharacter |
		eachCharacter = $:
			ifTrue: [theNumberOfDoppelpunkte:=theNumberOfDoppelpunkte+1]].
		"Durchiterieren mit do und schauen ob : match true ist falls ja variable hochzaehlen"
	theSubStrings := foundTimeCollection subStrings: $:.
	forkBoolean := self checkWhichValidCase: theSubStrings giveNumberofDoppelpunkte: theNumberOfDoppelpunkte.
	"((theSubStrings size = 3) 
		and: [(theSubStrings allSatisfy: [ :eachString |	
			eachString allSatisfy:[:eachCharacter | 	
				eachCharacter isDigit]]) 
			and:[theNumberOfDoppelpunkte = 2]])"
			(forkBoolean = true)
		ifTrue: [
		theHoursNumber :=(theSubStrings at: 1) asNumber.
		theMinutesNumber := (theSubStrings at: 2) asNumber.
		theSecondsNumber := (theSubStrings at: 3) asNumber.
			((theHoursNumber between: 0 and: 23)
				and:[(theMinutesNumber between: 0 and: 59)
			"and:[(theSubStrings at: 2) asNumber = (0 to: 59)"
					and:[(theSecondsNumber between: 0 and: 59)]])
					ifTrue: [checkedValidity := true]].
					"and: [(theSubStrings at: 3) asNumber = (0 to: 59)]]]."
	^checkedValidity
]

{ #category : 'CheckDate' }
HfuEstimatedReceipt >> checkValidTime: eachTime [
	| theSubStrings theNumberOfDoppelpunkte theHoursNumber theMinutesNumber theSecondsNumber checkedValidity forkBoolean|
	 "Transcript show: 'Hallo ich bin drin--------------------------------------------------------------------------------'."
	theNumberOfDoppelpunkte := 0.
	checkedValidity := false.
	forkBoolean := false.
	"Hier die Abfrage ob theNumberOfDoppelpunkte = 2 ist. Nur dann wird fortgesetzt"
	eachTime do: [ :eachCharacter |
		eachCharacter = $:
			ifTrue: [theNumberOfDoppelpunkte:=theNumberOfDoppelpunkte+1]].
		"Durchiterieren mit do und schauen ob : match true ist falls ja variable hochzaehlen"
	theSubStrings := eachTime subStrings: $:.
	forkBoolean := self checkWhichValidCase: theSubStrings giveNumberofDoppelpunkte: theNumberOfDoppelpunkte variableSubStringSize: 3 variableColonSize: 2.
   
	"((theSubStrings at: 2)(match: '## am'))
	or:[(theSubStrings at: 2 (match: '## pm'))])
	(and:[(theNumberOfDoppelpunkte = 1
	and:[(theSubStrings size = 2)]]))."
	"((theSubStrings size = 3)
		and: [(theSubStrings allSatisfy: [ :eachString |   
			eachString allSatisfy:[:eachCharacter |    
				eachCharacter isDigit]])
			and:[theNumberOfDoppelpunkte = 2]])"
			(forkBoolean = true)
		ifTrue: [
		theHoursNumber :=(theSubStrings at: 1) asNumber.
		theMinutesNumber := (theSubStrings at: 2) asNumber.
		theSecondsNumber := (theSubStrings at: 3) asNumber.
			((theHoursNumber between: 0 and: 23)
				and:[(theMinutesNumber between: 0 and: 59)
			"and:[(theSubStrings at: 2) asNumber = (0 to: 59)"
					and:[(theSecondsNumber between: 0 and: 59)]])
					ifTrue: [checkedValidity := true]].
					"and: [(theSubStrings at: 3) asNumber = (0 to: 59)]]]."
	^checkedValidity
]

{ #category : 'CheckDate' }
HfuEstimatedReceipt >> checkWhichValidCase: theSubStrings giveNumberofDoppelpunkte: numberOfDoppelpunkte [
 |variableColonSize variableSubStringSize aBoolean|
variableSubStringSize := 3.
variableColonSize := 2.
(aBoolean := ((theSubStrings size =variableSubStringSize) 
		and: [(theSubStrings allSatisfy: [ :eachString |	
			eachString allSatisfy:[:eachCharacter | 	
				eachCharacter isDigit]]) 
			and:[numberOfDoppelpunkte = variableColonSize ]]))
ifTrue:[			
^aBoolean]
]

{ #category : 'CheckDate' }
HfuEstimatedReceipt >> checkWhichValidCase: theSubStrings giveNumberofDoppelpunkte: numberOfDoppelpunkte variableSubStringSize: variableSubStringSize variableColonSize: variableColonSize [
 | aBoolean|
(aBoolean := ((theSubStrings size =variableSubStringSize) 
		and: [(theSubStrings allSatisfy: [ :eachString |	
			eachString allSatisfy:[:eachCharacter | 	
				eachCharacter isDigit]]) 
			and:[numberOfDoppelpunkte = variableColonSize ]]))
ifTrue:[			
^aBoolean]
ifFalse:[
self checkWhichValidCase: theSubStrings giveNumberofDoppelpunkte: numberOfDoppelpunkte variableSubStringSize: (variableSubStringSize-1) variableColonSize: (variableColonSize-1)
]
]

{ #category : 'FilterAmounts' }
HfuEstimatedReceipt >> checkWords [
	
	"Check Mwst ob 7 prozent, 19 prozent , Beides oder Keywoerter im Beleg Vorhanden sind"
	
	| aMwstDictionarySeven aMwstDictionaryNineTeen aMwstKeywordsDicitonary indexPlusOne | 
	
	aMwstDictionarySeven := (Dictionary new
	 at: 1 put: '7 %';
	 at: 2 put: '7.00%';
	 at: 3 put: '7%';
	 at: 4 put: '7,0%';
	 at: 5 put: '7 .000%';
	 at: 6 put: '7,01';
	 at: 7 put: '7,00X';
	 at: 8 put: '2=7,00%';
	 at: 9 put: '7.00';
	 at: 10 put: '2-7,00%';
	yourself).
	
	aMwstDictionaryNineTeen := (Dictionary new
	 at: 1 put: '19%';
	 at: 2 put: '19.00%';
	 at: 3 put: '19%';
	 at: 3 put: '19.00';
	 at: 4 put: '19,0%';
	 at: 5 put: '19 .000%';
	 at: 6 put: 'A:19,00%';
	 at: 7 put: '19,00%';
	 at: 8 put: '19,00';
	 at: 9 put:'19.00''%';
	 at: 10 put: '19,01';
	 at: 11 put: '19,09';
	 at: 12 put: '19,0%;';
	 at: 13 put: 'a:19,00';
	 at: 14 put: 'A-19,00X';
	 at: 15 put: '1=19,00%';
	 at: 16 put: 'EUR(19%)';
	 at: 17 put: 'A:19,00%';
	yourself).
	
	
	aMwstKeywordsDicitonary := (Dictionary new
	 at: 1 put: 'mwst.';
	 at: 2 put: 'mwst';
	 at: 3 put: 'X';
	 at: 4 put: '%';
	 at: 5 put: 'Umsatzsteuer';
	 at: 6 put: 'MwSt.';
	 at: 7 put: 'MwSt';
	 at: 8 put: 'MWST%';
	 at: 9 put: 'USt.';
	 at: 10 put: 'MWST-CODE';
	 at: 11 put: 'MWST-Betrag';
	 at: 12 put: 'MWST%';
	 at: 13 put: 'Vorgangs-Nr.00';
	 at: 14 put: 'letto-Warenwert';
	 at: 15 put: 'MwSt.%';
	 at: 15 put: 'VAT';
	 at: 16 put: 'Mehrwertsteuer';
	 at: 17 put: 'USt1';
	 at: 18 put: 'Steuer';
	 at: 19 put: 'nth.MwSt';
	 at: 20 put: 'MWSt.Betr.00';
	 at: 21 put: 'MWST';
	 at: 22 put: 'USt';
	 at: 23 put: 'Autor.00';
	 yourself).
		
	self allWordsCollection doWithIndex:[:eachWord :index | 

	((aMwstKeywordsDicitonary includes: eachWord)
	ifTrue: [ self mwstWord: true  ])].
		
	self allWordsCollection doWithIndex:[:eachWord  :index |
	
		((index + 1) <= ((self allWordsCollection) size))
			ifTrue:[ indexPlusOne := (index +1)]
				ifFalse:[ indexPlusOne := ((self allWordsCollection) size)].

		((HfuEstimatedReceipt isNetWordDictionary) includes: eachWord)
		ifTrue: [ self netWord: true  ].
		
		((HfuEstimatedReceipt isGrossWordDictionary) includes: eachWord)
		ifTrue: [ self grossWord: true  ].
		
		(((aMwstDictionarySeven includes: eachWord)  and:[self mwstWord isTrue]) or:[(( '*7*' match: (self allWordsCollection at: index)) and:[ '*%*' match: (self allWordsCollection at: indexPlusOne )])])
		ifTrue: [(self checkSouroundWords: eachWord index: index)
					ifTrue:[self mwstSeveWord: true]].
		
		(((aMwstDictionaryNineTeen includes: eachWord) and:[self mwstWord isTrue]) or:[(( '*19*' match: (self allWordsCollection at: index)) and:[ '*%*' match: (self allWordsCollection at: indexPlusOne )])])
		ifTrue: [ (self checkSouroundWords: eachWord index: index)
					ifTrue:[self mwstNineteenWord: true]].
		
		((HfuEstimatedReceipt isKeyWordDictionary) includes: eachWord)
		ifTrue: [ self amountKeyword:  true].
		
		((self mwstNineteenWord isTrue) and:[(self mwstSeveWord isTrue)])
		ifTrue: [self hasTwoTax: true].
	].
			((self mwstNineteenWord isTrue) and:[(self mwstSeveWord isTrue)])
		ifTrue: [self hasTwoTax: true].

]

{ #category : 'FilterAmounts' }
HfuEstimatedReceipt >> convertCollectionToCent: aCollection [

 | convertetCollectionInCent |
 
 convertetCollectionInCent := OrderedCollection new.
 
	aCollection do:[:eachAmount |
		(eachAmount isString)
		ifTrue:[convertetCollectionInCent add: (self convertToCentAmount: eachAmount)]].
	
	^convertetCollectionInCent.
]

{ #category : 'FilterAmounts' }
HfuEstimatedReceipt >> convertToCentAmount: aAmount [

	| amountCollection theCentAmount amountEuro amountCent |
	
	(('*,##' match: aAmount)
		 ifTrue: [
		 aAmount removeAllSpaces.
		 amountCollection := aAmount subStrings: ','. ]).
		 (('*.##' match: aAmount)
		  ifTrue: [
		  aAmount removeAllSpaces.
		  amountCollection := aAmount subStrings: '.'. ]).

		(('*,##' match: aAmount) or:['*.##' match: aAmount] )
		ifTrue: [
		
	((amountCollection size) = 2)
		ifTrue: [
		
		(amountCollection at: 1) do:[
		:eachChar | ((eachChar digitValue) >= 0)
		ifFalse: [
			^1
			]
		].
		(amountCollection at: 2) do:[
		:eachChar | ((eachChar digitValue) >= 0)
		ifFalse: [
			^1
			]
		].
									amountEuro := (amountCollection at: 1) asNumber.
									amountCent := (amountCollection at: 2) asNumber.
		
									theCentAmount := amountCent + (amountEuro * 100).
			
									^theCentAmount 
	]ifFalse: [
		^1
	]
	
	].

]

{ #category : 'ScanReceipt' }
HfuEstimatedReceipt >> createJson: aPath index: aIndex char: aChar [

	|  aString |

	aString := ''.
		
	47 to: aIndex do: [ :eachNumber | 
	ClwHttpRequest useSstHttpClient.
	ClwImageMagickStarter programPathOrName: 'C:\Program Files\ImageMagick-7.0.10-Q16\magick.exe'.
	ClwAwsCredentials
	 newDefaultAccessKeyId: 'AKIAXSRJKNZ4IBSQ7NOG'
	 secretAccessKey: '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'.

		ClwTextractHelper debugReceiptWithLines: (aPath , '\' , (aChar) asString,  (eachNumber padWithZerosDesiredSize: 3) asString , '.png').].
	


]

{ #category : 'API',
 #vaCategories : ['API','CheckDate'] }
HfuEstimatedReceipt >> date [

	^date
]

{ #category : 'API',
 #vaCategories : ['API','CheckDate'] }
HfuEstimatedReceipt >> date: anObject [

	date := anObject
]

{ #category : 'FilterAmounts' }
HfuEstimatedReceipt >> designateGrossAmount [

		| netCollectionIsEmpty grossCollectionIsEmpty keywordCollectionIsEmpty aGrossAmountValue aSecondGrossAmountValue |
		
		(self netAmountCollection isEmpty)
		ifTrue: [netCollectionIsEmpty := true]
		ifFalse: [netCollectionIsEmpty := false].
		
		(self grossAmountCollection isEmpty)
		ifTrue: [grossCollectionIsEmpty := true] 
		ifFalse: [grossCollectionIsEmpty := false].
		
		(self keywordAmountCollection isEmpty)
		ifTrue: [keywordCollectionIsEmpty := true] 
		ifFalse: [keywordCollectionIsEmpty := false].
		
		
		((self mwstSeveWord isTrue) or:[(self mwstNineteenWord isTrue)])
		ifTrue:[
		self calculateTaxAmount.
		(self grossFromCalculateTax isNil)
		" Wenn grossFromCalculateTax ungleich False ist dann schreib den Wert in grossAmount:"
		ifFalse:[self grossAmount: ((((self grossFromCalculateTax) asFloat) / 100) printNumericStringTwoDecimals)] "GrossAmount zuweisung"		
		" Wenn grossFromCalculateTax gleich NIL  ist dann nimm aus der alle Zahlen Collection den Hoechstenbetrag"
		ifTrue:[((self receiptAmountsCollection) isEmpty)
					ifTrue:[self grossAmount: '00.00']
					ifFalse:[self grossAmount:  (((self filterOneHighestAmount: (self receiptAmountsCollection)) asFloat) printNumericStringTwoDecimals)]"GrossAmount zuweisung"		
		]]
		ifFalse:[ 
		(grossCollectionIsEmpty)
		ifTrue:[ (netCollectionIsEmpty)
					ifTrue: [ (keywordCollectionIsEmpty)
								ifFalse: [ aGrossAmountValue := self filterOneHighestAmount: (self keywordAmountCollection).
											self grossAmount:(((aGrossAmountValue) asFloat) printNumericStringTwoDecimals)] "GrossAmount zuweisung" 
								ifTrue:[(self receiptAmountsCollection isEmpty)
											ifFalse:[  self grossAmount:  (((self filterOneHighestAmount: (self receiptAmountsCollection)) asFloat) printNumericStringTwoDecimals)] "GrossAmount zuweisung"	
											ifTrue:[self grossAmount: '00.00']]]
								"NetCollection ist nicht leer!"
								ifFalse: [(keywordCollectionIsEmpty) 
												ifFalse:[self mergeAmountCollections: (self netAmountCollection) secondCollection: (self keywordAmountCollection)  keyword: 'net'.
																		aGrossAmountValue := self filterOneHighestAmount: (self netAmountCollection).
																		aSecondGrossAmountValue := self filterOneHighestAmount: (self keywordAmountCollection).
																		(aSecondGrossAmountValue >= aGrossAmountValue)
																		ifTrue:[ ((self receiptAmountsCollection includes: aSecondGrossAmountValue) or:[self amountKeyword])
																					ifTrue:[self grossAmount: (((aSecondGrossAmountValue) asFloat) printNumericStringTwoDecimals)]] "GrossAmount zuweisung"
																		ifFalse:[(((self receiptAmountsCollection includes: aGrossAmountValue) or:[self netWord]) or:[self amountKeyword])
																					ifTrue:[self grossAmount:(((aGrossAmountValue) asFloat) printNumericStringTwoDecimals)]]] "GrossAmount zuweisung" 
					]]
			
		ifFalse:[ ((self grossAmountCollection size) == 1)
					ifTrue:[aGrossAmountValue := (self filterOneHighestAmount: (self grossAmountCollection)).  
								(netCollectionIsEmpty or:[keywordCollectionIsEmpty])
								ifFalse:[ ((self netAmountCollection includes: aGrossAmountValue) or:[self keywordAmountCollection includes: aGrossAmountValue])
												ifTrue:[((self grossWord))
															ifTrue:[self grossAmount: (((aGrossAmountValue) asFloat) printNumericStringTwoDecimals)] "GrossAmount zuweisung" 
															ifFalse:[ (self amountKeyword)
																			ifTrue:[self grossAmount: (((aGrossAmountValue) asFloat) printNumericStringTwoDecimals)] "GrossAmount zuweisung" 
																			ifFalse:[self netAmount: (((aGrossAmountValue) asFloat) printNumericStringTwoDecimals)]]]]									
									]
									ifFalse: [(grossCollectionIsEmpty)
													ifFalse: [(keywordCollectionIsEmpty)
															ifFalse:[self mergeAmountCollections: (self grossAmountCollection) secondCollection: (self keywordAmountCollection)  keyword: 'gross'.
																		aGrossAmountValue := self filterOneHighestAmount: (self grossAmountCollection).
																		(((self receiptAmountsCollection includes: aGrossAmountValue) and:[self grossWord]) or:[self amountKeyword])
																		ifTrue: [self grossAmount: (((aGrossAmountValue) asFloat) printNumericStringTwoDecimals)] "GrossAmount zuweisung" 
																		ifFalse: [((self netAmountCollection includes: aGrossAmountValue) and:[self netWord])
																					ifTrue:[ self netAmount: (((aGrossAmountValue) asFloat) printNumericStringTwoDecimals)]
																		]]
																		"GrossAmountCollection ist befÃ¼lt KeywordCollection nicht!"
																		ifTrue:[aGrossAmountValue := self filterOneHighestAmount: (self grossAmountCollection).
																					(((self receiptAmountsCollection includes: aGrossAmountValue) and:[self grossWord]) or:[self amountKeyword])
																						ifTrue: [self grossAmount:(((aGrossAmountValue) asFloat) printNumericStringTwoDecimals)]]] "GrossAmount zuweisung" 

									]]].
]

{ #category : 'FilterAmounts' }
HfuEstimatedReceipt >> designateMwstAmount [

			| grossCent netCent aResult|

			((((self grossAmount) == '00.00') and:[(self netAmount) == '00.00']) or:[(((self grossAmount) isNil) and:[(self netAmount) isNil])])
			ifFalse: [
			grossCent := ((self convertToCentAmount: (self grossAmount)) / 100) asFloat. 
			netCent :=  ((self convertToCentAmount: (self netAmount)) / 100) asFloat.
						
			aResult := grossCent - netCent.
			
			aResult := (((aResult) asFloat) printNumericStringTwoDecimals).
			
			((aResult) > (self netAmount))
			ifTrue:[ self mwst: (self netAmount).
						self netAmount: aResult]
			ifFalse:[
			(aResult == (self grossAmount))
			ifTrue:[ self mwst: '00.00']
			ifFalse:[self mwst: aResult]]]
]

{ #category : 'FilterAmounts' }
HfuEstimatedReceipt >> designateNetAmount [

			| netCollectionIsEmpty grossCollectionIsEmpty keywordCollectionIsEmpty aNetAmount aNetAmount2 mwstSevenAmount mwstNineteenAmount 
				mwstSevenBoolean mwstNineteenBoolean secondHighestAmount1 secondHighestAmount2 secondHighestAmount3 |

			"ist netWord gesetzt und ist grossAmount ungleich null oder nil"
			"Das bedeutet es gibt neben dem GrossAmount auch ein NetAmount"
			
		(self netAmountCollection isEmpty)
		ifTrue: [netCollectionIsEmpty := true]
		ifFalse: [netCollectionIsEmpty := false.
		secondHighestAmount1 := self filterSecondHighestAmount: (self netAmountCollection).
		].
		(self grossAmountCollection isEmpty)
		ifTrue: [grossCollectionIsEmpty := true] 
		ifFalse: [grossCollectionIsEmpty := false.
		secondHighestAmount2 := self filterSecondHighestAmount: (self grossAmountCollection).
		].
		(self keywordAmountCollection isEmpty)
		ifTrue: [keywordCollectionIsEmpty := true] 
		ifFalse: [keywordCollectionIsEmpty := false.
		secondHighestAmount3 := self filterSecondHighestAmount: (self keywordAmountCollection).
		].
		((self mwstSeveWord isNil) or:[self mwstSeveWord isTrue])
		ifFalse:[mwstSevenAmount := self mwstSeveWord.
					mwstSevenBoolean := true]
		ifTrue:[ mwstSevenBoolean := false].			
		((self mwstNineteenWord isNil) or:[self mwstNineteenWord isTrue])
		ifFalse:[mwstNineteenAmount := self mwstNineteenWord.
					mwstNineteenBoolean := true.]
			ifTrue:[ mwstNineteenBoolean := false].			
			
			"GrossAmount und TaxWerte zur NetAmount bestimmung"
			((((self netWord isTrue) and:[(self grossAmount ~= nil) or:[self grossAmount ~= '00.00']]) or:[((self grossWord isTrue) or:[self amountKeyword isTrue])]) and:[((mwstSevenBoolean) or:[(mwstNineteenBoolean)])])
			ifTrue:[ ((mwstNineteenBoolean) and:[mwstSevenBoolean])
						ifTrue:[ aNetAmount := self filterNetAmountWithTaxAmounts: (mwstSevenAmount + mwstNineteenAmount).
									self netAmount: (((aNetAmount) asFloat) printNumericStringTwoDecimals)]
						ifFalse:[(mwstNineteenBoolean)
									ifTrue:[aNetAmount := (self filterNetAmountWithTaxAmounts: (mwstNineteenAmount)).
												self netAmount: (((aNetAmount) asFloat) printNumericStringTwoDecimals)]			
									ifFalse:[(mwstSevenBoolean)
												ifTrue:[ aNetAmount := self filterNetAmountWithTaxAmounts: (mwstSevenAmount).
															self netAmount: (((aNetAmount) asFloat) printNumericStringTwoDecimals)]
												ifFalse:[ 
															(self receiptAmountsCollection isEmpty)
															ifFalse:[(aNetAmount := self filterSecondHighestAmount: (self receiptAmountsCollection)).
																		self netAmount: (((aNetAmount) asFloat) printNumericStringTwoDecimals)]
															ifTrue:[self netAmount: '00.00']]]]
										
					]
					"Nur GrossAmount, keine Taxes vorhanden fÃ¼r NetAmount bestimmung"
					ifFalse:[((((self netWord isTrue) or:[((self grossWord isTrue) or:[self amountKeyword isTrue])]) and:[(self grossAmount ~= nil) and:[self grossAmount ~= '00.00']])) 
								ifTrue:[((netCollectionIsEmpty))
											ifFalse:[(self netAmountCollection size > 1)
														ifTrue:[
														aNetAmount := (self filterSecondHighestAmount: (self netAmountCollection)).
														aNetAmount2 := (self filterOneHighestAmount: (self netAmountCollection))]
														"liste ist gleich eins nur ein wert"
														ifFalse:[
														aNetAmount := (self filterOneHighestAmount: (self netAmountCollection)).
														self netAmount: (((aNetAmount) asFloat) printNumericStringTwoDecimals)]. 
														(((aNetAmount asNumber) < ((self grossAmount) asNumber)) and:[self netAmountCollection includes: (self grossAmount)])
														ifTrue:[self netAmount: (((aNetAmount) asFloat) printNumericStringTwoDecimals)]
														ifFalse:[ ((aNetAmount2 ~= (self grossAmount)) and:[((self checkIsAmountFormat: aNetAmount2) and:[aNetAmount2 ~= nil])])
																	ifTrue:[self netAmount: (((aNetAmount2) asFloat) printNumericStringTwoDecimals)]
																	ifFalse:[self netAmount: (((aNetAmount) asFloat) printNumericStringTwoDecimals)]]]
											
											"netAmountcollectin ist Empty schau in den Anderen zwei nach ob der GrossAmount vorhanden ist und ob der zweite wert kleiner und ungleich ist !!!" 
											ifTrue:[ ((grossCollectionIsEmpty) or:[keywordCollectionIsEmpty])
														ifFalse:[  
																		(self keywordAmountCollection size >= 2)
																		ifTrue:[aNetAmount := (self filterSecondHighestAmount: (self keywordAmountCollection))]
																		ifFalse:[ (keywordCollectionIsEmpty) 
																					ifFalse:[aNetAmount := (self filterOneHighestAmount: (self keywordAmountCollection))]
																					ifTrue:[aNetAmount := 0]].
																					
																	(self grossAmountCollection size >= 2)
																	ifTrue: [aNetAmount2 := (self filterSecondHighestAmount: (self grossAmountCollection))]
																	ifFalse:[ (grossCollectionIsEmpty) 
																					ifFalse:[aNetAmount2 := (self filterOneHighestAmount: (self grossAmountCollection))]
																					ifTrue:[aNetAmount2 := 0]].
																					
																	(((aNetAmount asNumber) < (self grossAmount) asNumber) and:[self keywordAmountCollection includes: (self grossAmount)]) 
																				ifTrue:[self netAmount: (((aNetAmount) asFloat) printNumericStringTwoDecimals)]
																				ifFalse:[ ((aNetAmount2 < (self grossAmount)) and:[self grossAmountCollection includes: (self grossAmount)]) 
																							ifTrue:[self netAmount: (((aNetAmount2) asFloat) printNumericStringTwoDecimals)]
																							ifFalse:[self netAmount: '00.00']]
																	]
																	ifTrue:[self netAmount: '00.00']
																	]]
																	"Kein GrossAmount vorhanden"
																	 ifFalse:[(netCollectionIsEmpty)
																				ifFalse: [aNetAmount := (self filterOneHighestAmount: (self netAmountCollection)).
																							self netAmount: (((aNetAmount) asFloat) printNumericStringTwoDecimals)]
																				ifTrue:[	(keywordCollectionIsEmpty)
																							ifFalse: [aNetAmount := (self filterOneHighestAmount: (self keywordAmountCollection)).
																							self netAmount: (((aNetAmount) asFloat) printNumericStringTwoDecimals)]
																							ifTrue:[(grossCollectionIsEmpty) 
																										ifFalse: [aNetAmount := (self filterHighestAmount: (self keywordAmountCollection)).
																													self netAmount: (((aNetAmount) asFloat) printNumericStringTwoDecimals)]
																										ifTrue:[self netAmount: '00.00']]]]]
]

{ #category : 'API',
 #vaCategories : ['API','CheckDate'] }
HfuEstimatedReceipt >> endDate [

	^endDate
]

{ #category : 'API',
 #vaCategories : ['API','CheckDate'] }
HfuEstimatedReceipt >> endDate: anObject [

	endDate := anObject
]

{ #category : 'ScanReceipt' }
HfuEstimatedReceipt >> fillAllTextractLinesCollection: aNumber [

		self allTextractLinesCollection: (HfuEstimatedReceipt receipts at: aNumber) estimatedBetterLines.
		"self allTextractWordsCollection first third text."
		"self allTextractLinesCollection second first geometry polygon."
	"self allTextractLinesCollection first second text."
		"self allTextractLinesCollection at: 10 second text."
		"self halt."
		"Transcript show: (self allTextractLinesCollection at: 1)."
		
		
			
]

{ #category : 'ScanReceipt' }
HfuEstimatedReceipt >> fillAllTextractWordsCollection: aNumber [

		self allTextractWordsCollection: (HfuEstimatedReceipt receipts at: aNumber) allTextractWords.
			
]

{ #category : 'ScanReceipt' }
HfuEstimatedReceipt >> fillAllWordsCollection: aNumber [

		self allWordsCollection: (HfuEstimatedReceipt receipts at: aNumber) allWords.
		self removeWhitespaceOfCollectionAttributs: (self allWordsCollection).
]

{ #category : 'FilterAmounts' }
HfuEstimatedReceipt >> fillDatas [
	"Alle Datensaetze fuellen"
	
	HfuEstimatedReceipt fillAllKeyWordDictionary.
	HfuEstimatedReceipt fillKeyWordDictionary.
	HfuEstimatedReceipt fillGrossWordDictionary.
	HfuEstimatedReceipt fillNetWordDictionary.
	self checkWords.
	self reduceAllWordsCollectionByKeyWord.
	self filterAmountWithAllTextractWordsCollection.
	self filterAmountValuesWithAllWordsCollection.
	
	
	
]

{ #category : 'FilterAmounts' }
HfuEstimatedReceipt >> fillReceiptAmountsCollectionInCent: aCollection [

 | convertetCollectionInCent |
 
 convertetCollectionInCent := OrderedCollection new.
 
	aCollection do:[:eachAmount |
		(self checkIsAmountFormat: eachAmount)
		ifTrue:[convertetCollectionInCent add: (self convertToCentAmount: eachAmount)]].
	
	self receiptAmountsCollectionInCent: convertetCollectionInCent.
]

{ #category : 'FilterAmounts' }
HfuEstimatedReceipt >> filterAmountValuesWithAllWordsCollection [
	
	"Filtert die AllWordsCollection nach dem ersten Gefunden Keywort nach Zahl die dem Format entsprechen aus "
	
	|  aKeyWordsDictionary aAllWordsCollection aAllWordsCollection2 aAllWordsCollection3 theValuesAfterKeywordsCollection  
	     aString  maxIndexOfSmallerCollection minIndexOfSmallerCollection aBoolean  | 
	
	aKeyWordsDictionary :=  HfuEstimatedReceipt isAllKeyWordDictionary.
	
	aBoolean := true.
	
	aAllWordsCollection3 := OrderedCollection new.
	aAllWordsCollection2:= OrderedCollection  new.
	aAllWordsCollection := OrderedCollection  new.
	
	aAllWordsCollection:= self allWordsCollection.
	
		aAllWordsCollection doWithIndex:[
		:eachWord :index | 
		((aKeyWordsDictionary includes: eachWord)
		ifTrue: [
					aAllWordsCollection2 add: eachWord.
					
					((index + 20 <= aAllWordsCollection size)
					ifTrue:[ maxIndexOfSmallerCollection := index + 20.
								minIndexOfSmallerCollection := index + 1.]
					ifFalse:[ maxIndexOfSmallerCollection := aAllWordsCollection size.
								((index + 1 <= aAllWordsCollection size)
								ifFalse: [ minIndexOfSmallerCollection := index +1 .] 
								ifTrue: [ minIndexOfSmallerCollection := aAllWordsCollection size.])]).
								
					minIndexOfSmallerCollection to: maxIndexOfSmallerCollection do:[:eachWordAfterFoundKeyword |  
					(((((((((('*,##' match: (aAllWordsCollection at: eachWordAfterFoundKeyword)) 
							or:['*.##' match: (aAllWordsCollection at: eachWordAfterFoundKeyword)]) 
								or:['#,##' match: (aAllWordsCollection at: eachWordAfterFoundKeyword)]) 
									or:['#.##' match: (aAllWordsCollection at: eachWordAfterFoundKeyword)]) 
										or:['*,' match: (aAllWordsCollection at: eachWordAfterFoundKeyword)]) 
											or:['*.' match: (aAllWordsCollection at: eachWordAfterFoundKeyword)]) 
												or:['*.##*' match: (aAllWordsCollection at: eachWordAfterFoundKeyword)]) 
													or:['*,##*' match: (aAllWordsCollection at: eachWordAfterFoundKeyword)]) 
														or:[false = ( ('*19*' match: (aAllWordsCollection at: eachWordAfterFoundKeyword)) and:[('*%*' match: (aAllWordsCollection at: (minIndexOfSmallerCollection)))] )])
															or:[false = ( ('*7*' match: (aAllWordsCollection at: eachWordAfterFoundKeyword)) and:[('*%*' match: (aAllWordsCollection at: (minIndexOfSmallerCollection)))] )])
					
					ifTrue:[ aString := (aAllWordsCollection at: eachWordAfterFoundKeyword).
										
										((('*,' match: aString) or:['*.' match: aString]) 
									ifTrue: [ 	
												aString := (aString,'00').
												aAllWordsCollection replaceFrom: index to: index  withObject:  aString.
											]
									ifFalse:[((',##' match: aString) or:['.##' match: aString])
											ifTrue: [aString := ('0',aString).
											aAllWordsCollection replaceFrom: index to: index  withObject:  aString.]
											]).

									(('*,##' match: aString)
									ifTrue: [theValuesAfterKeywordsCollection := aString subStrings: ','. ]).
									
									((	'*.##' match: aString)
									ifTrue: [theValuesAfterKeywordsCollection := aString subStrings: '.'. ]).
									
									((theValuesAfterKeywordsCollection isNil)
									ifFalse:[
									(((((((theValuesAfterKeywordsCollection at: 1) hasOnlyDigits) and:[((theValuesAfterKeywordsCollection at: 2) hasOnlyDigits)]) and:[(false=('*.##.*' match: aString))]) and:[(false=('*%*' match: aString))])))
									ifTrue:[ aAllWordsCollection2 add: aString]
											])
												]]
													])
															].

					aAllWordsCollection2 doWithIndex:[:eachAttribut :index | (((eachAttribut hasAnyLetter) and:[aBoolean = true.]) 
					ifTrue:[ aAllWordsCollection3 add: eachAttribut.
								aBoolean := false.]
					ifFalse:[((((eachAttribut hasAnyDigit) and:[(aBoolean = false)]) )
								ifTrue: [aAllWordsCollection3 add: eachAttribut.
											aBoolean := true])])].
											
					 self removePointsFromNumber: aAllWordsCollection3.
					self filterGrossAmountAndNetAmountbyKeywords: aAllWordsCollection3.
]

{ #category : 'FilterAmounts' }
HfuEstimatedReceipt >> filterAmountWithAllTextractWordsCollection [
	"Filtert den BruttoBetrag"
	
	| aGrossDictionary aNetDictionary aKeyWordsDictionary aAmountPolygonCollection aKeywordPolygonCollection |
		
	aAmountPolygonCollection:= OrderedCollection  new.
	aKeywordPolygonCollection := OrderedCollection  new.
	
	self grossAmountCollection: Set new.
	self netAmountCollection: Set new.
	self keywordAmountCollection: Set new.
	"Dictionaries um Keywoerter zu pruefen, wenn vorhanden dann setzte Key-boolean auf True"
	aGrossDictionary :=  HfuEstimatedReceipt isGrossWordDictionary.
	 aNetDictionary :=  HfuEstimatedReceipt isNetWordDictionary.
	aKeyWordsDictionary :=  HfuEstimatedReceipt isKeyWordDictionary.
	 

		self allTextractWordsCollection doWithIndex:[:eachWord :innerCollectionIndex| 
		"KeyWoerter sind in KassenZettel vorhanden?"
		(((aNetDictionary includes: (eachWord text)) or:[aGrossDictionary includes: (eachWord text)]) or:[aKeyWordsDictionary includes: (eachWord text)])
		ifTrue:[ 
					"Schreibe polygon von Word in Collection"
					aKeywordPolygonCollection := ((eachWord geometry) polygon).  
					"Kuerze Punkte um 0.01 preazision zu erhalten"
					self truncatePoint: aKeywordPolygonCollection.
					
					"Itteriere durch (Index -10) bis (self allTextractWordsCollection size)  und gebe eachAttributPolygon den Wert des Polygons der self (allTextractWordsCollection at: eachAttribut)"
					((innerCollectionIndex - 10) abs) to: self allTextractWordsCollection size do:[:eachAttribut |  | eachAttributPolygon eachTextractWord | eachAttributPolygon :=  (((self allTextractWordsCollection at: eachAttribut) geometry) polygon).
					"Uebergebe das Polygon aAmountPolygonCollection "
					aAmountPolygonCollection := eachAttributPolygon.
					"Wieder nachkommastellen 0.01 abschneiden"
					self truncatePoint: aAmountPolygonCollection.
					"eachTextractWord seinem Text zuweisen"
					eachTextractWord := (self allTextractWordsCollection at: eachAttribut) text.
					
					"Itteriere durch die 4 Eckpunkte des Polygons, pruefe ob Polygon in Range liegt also gleich ist wie eachWord"
					1 to: 4 do:[:indexFromKeyWordPolygon |   aAmountPolygonCollection doWithIndex:[:eachPoint :index| ( (((((eachPoint)  x)  - 0.01) <= ((aKeywordPolygonCollection at: indexFromKeyWordPolygon) x)) and:[(( ((eachPoint) x) + 0.01) >= ((aKeywordPolygonCollection at: indexFromKeyWordPolygon) x))]) 
						or:[ ((( ((eachPoint) y) - 0.01) <= ((aKeywordPolygonCollection at: indexFromKeyWordPolygon) y)) and:[(( ((eachPoint) y)   + 0.01) >= ((aKeywordPolygonCollection at: indexFromKeyWordPolygon) y))])] ) 
							
						ifTrue:[ 
						"Ist Word in allTextractWordsCollection nicht das gleiche wie eachWord und hat es nur Zahlen und passt es auf Betrag Format und ist es kein Datum oder %"
						((((((self allTextractWordsCollection at: eachAttribut) ~= eachWord)) 
								and:[((true = (eachTextractWord) hasAnyDigit) and:[('*.##' match: (eachTextractWord)) or:[('*,##' match: (eachTextractWord))]]) and:[(((eachTextractWord) hasAnyLetter) isFalse)]])
								and:[(false=('*.##.*' match: eachTextractWord))]) and:[(false=('*%*' match: eachTextractWord))])
								
								"Pruefe ob der Text von eachWord in aNetDictionary  vorhanden ist: ja ? add zu netAmountCollection. Das gleiche mit grossAmountCollection"
								ifTrue:[
											(aNetDictionary includes: (eachWord text))
								ifTrue:[ self netAmountCollection add: (((self allTextractWordsCollection at: eachAttribut ) text) removeAllSpaces) ].
											(aGrossDictionary includes: (eachWord text))
								ifTrue:[self grossAmountCollection add: (((self allTextractWordsCollection at: eachAttribut) text) removeAllSpaces)].
						"ist eachWord in aKeyWordsDictionary dann add zu keywordAmountCollection"
						(aKeyWordsDictionary includes:(eachWord text))
						ifTrue:[ self keywordAmountCollection add: (((self allTextractWordsCollection at: eachAttribut) text) removeAllSpaces)].
						]]]
					]]]].

					self removePointsFromNumber: self netAmountCollection.
					self removePointsFromNumber: self grossAmountCollection.
					self removePointsFromNumber: self keywordAmountCollection.
					
	
]

{ #category : 'FilterAmounts' }
HfuEstimatedReceipt >> filterGrossAmountAndNetAmountbyKeywords: aAmountCollection [

	 | aGrossAmountSet aNetAmountSet aKeywordsSet |
		
	aGrossAmountSet :=  Set  new.
	aNetAmountSet := Set new.
	aKeywordsSet := Set new.
	 
		aAmountCollection doWithIndex:[ :eachAttribut :index | (((HfuEstimatedReceipt isGrossWordDictionary) includes: eachAttribut) or:[(HfuEstimatedReceipt isKeyWordDictionary) includes: eachAttribut])
		ifTrue:[ 
		((index +1) <= aAmountCollection size)
		ifTrue: [
		(aGrossAmountSet add:  (aAmountCollection at: (index+1))).
		((HfuEstimatedReceipt isKeyWordDictionary) includes: eachAttribut)
		ifTrue: [ aKeywordsSet add: (aAmountCollection at: (index+1))]]]
		ifFalse:[  ((HfuEstimatedReceipt isNetWordDictionary) includes: eachAttribut)
						ifTrue:[  
						((index +1) <= aAmountCollection size)
						ifTrue: [(aNetAmountSet add:  (aAmountCollection at: (index+1)))]]]].
						
		self mergeAmountCollections: aNetAmountSet secondCollection: (self netAmountCollection) keyword: 'net'.
		self mergeAmountCollections: aGrossAmountSet secondCollection: (self grossAmountCollection) keyword: 'gross'.
		self mergeAmountCollections: aKeywordsSet secondCollection: (self keywordAmountCollection) keyword: 'keyword'.
		
]

{ #category : 'FilterAmounts' }
HfuEstimatedReceipt >> filterHighestAmount: aCollectionOfAmounts [
	
	"Filtert den hoechsten Betrag raus"
	
	| aResultCollection aHighstAmountCollection aLastIndex | 

		aResultCollection := OrderedCollection new.
		aHighstAmountCollection := OrderedCollection new.
		aHighstAmountCollection addAll: aCollectionOfAmounts.
		aLastIndex := ((aHighstAmountCollection lastIndex) -1 ).
		
		((aHighstAmountCollection size) >= 4)
		ifTrue:[ 
			1 to: 3 do:[:index | aResultCollection add: (aHighstAmountCollection at: (aLastIndex - 1)). 
							aHighstAmountCollection removeLast. ]]
		ifFalse:[ aResultCollection addAll: aCollectionOfAmounts].    
			
	^aResultCollection.
]

{ #category : 'FilterAmounts' }
HfuEstimatedReceipt >> filterNetAmountWithTaxAmounts: aTaxAmount [

			| aResultAmount aResultAmount2 aResultAmount3 aResultNetAmount |
			
			aResultAmount2 := ((self convertToCentAmount: (self grossAmount)) / 100) asFloat.
			aResultAmount := ((aResultAmount2) - aTaxAmount).
			aResultAmount3 := (((aResultAmount) asFloat) printNumericStringTwoDecimals).

			(((self netWord isTrue) or:[(self grossWord isTrue)]) or:[self amountKeyword isTrue])
			ifTrue:[ (self netAmountCollection includes: aResultAmount3)
						ifTrue:[ aResultNetAmount := (((aResultAmount3) asFloat) printNumericStringTwoDecimals).
									^aResultNetAmount] "netAmount zuweisen"
						ifFalse:[((self grossAmountCollection includes: aResultAmount3) or:[self keywordAmountCollection includes: aResultAmount3])
									ifTrue:[ ^(((aResultAmount3) asFloat) printNumericStringTwoDecimals)] "netAmount zuweisen"
									ifFalse:[(self receiptAmountsCollection includes: aResultAmount3)
												ifTrue:[ ^ (((aResultAmount3) asFloat) printNumericStringTwoDecimals)] "netAmount zuweisen"
												ifFalse:[ ^aResultAmount3]]]]. "netAmount zuweisen"
]

{ #category : 'FilterAmounts' }
HfuEstimatedReceipt >> filterOneHighestAmount: aCollectionOfAmounts [
	
	"Filtert den hoechsten Betrag raus"

	| aHighstAmountCollection  theEachCollection highestAmountEuro highestAmountCent aResultAmount | 

		((aCollectionOfAmounts isEmpty) or:[aCollectionOfAmounts isNil])
		ifTrue:[^0].

		aHighstAmountCollection := OrderedCollection new.
		aHighstAmountCollection addAll: aCollectionOfAmounts.
	
		highestAmountEuro := 0.
		highestAmountCent := 0.
		aResultAmount := 0.
		
		aHighstAmountCollection do:[
		:eachWord |
		(('*#,##' match: eachWord) or:['*#.##' match: eachWord])
		ifTrue: [
		(('*#,##' match: eachWord)
		 ifTrue: [theEachCollection := eachWord subStrings: ','. ]).
		 (('*#.##' match: eachWord)
		  ifTrue: [theEachCollection := eachWord subStrings: '.'. ]).

			( ((theEachCollection at: 1) asNumber) >= highestAmountEuro)
			ifTrue: [
				((((theEachCollection at: 2) asNumber) >= highestAmountCent) or:[(((theEachCollection at: 2) asNumber) <= highestAmountCent)])                
				ifTrue: [
				(((theEachCollection at: 1) hasOnlyDigits) and:[((theEachCollection at: 2) hasOnlyDigits)])
				ifTrue:[highestAmountEuro := (theEachCollection at: 1) asNumber.
							highestAmountCent := (theEachCollection at: 2) asNumber.
								aResultAmount := eachWord]]]]].

					^aResultAmount.  
]

{ #category : 'FilterAmounts' }
HfuEstimatedReceipt >> filterSecondHighestAmount: aCollectionOfAmounts [
	
	"Filtert die drei  hoechsten Betrag raus"
	
	| aResultCollection aHighstAmountCollection aLastIndex | 

		aResultCollection := OrderedCollection new.
		aHighstAmountCollection := OrderedCollection new.
		aHighstAmountCollection addAll: aCollectionOfAmounts.
		aLastIndex := ((aHighstAmountCollection lastIndex) -1 ).
		
		((aHighstAmountCollection size) >= 3)
		ifTrue:[ 
			1 to: 2 do:[:index | aResultCollection add: (aHighstAmountCollection at: (aLastIndex - 1)). 
							aHighstAmountCollection removeLast. ]]
		ifFalse:[ aResultCollection addAll: aCollectionOfAmounts].    
			
			(aResultCollection isEmpty)
			ifTrue:[^'00,00'].
			
			(aResultCollection size == 1)
			ifTrue:[^aResultCollection at: 1].
			
		((aResultCollection at: 1)	> (aResultCollection at: 2))
		ifTrue:[^(aResultCollection at: 2)]	
		ifFalse:[^(aResultCollection at: 1)].		
]

{ #category : 'CheckDate' }
HfuEstimatedReceipt >> foundDateCollection [

	^foundDateCollection
]

{ #category : 'CheckDate' }
HfuEstimatedReceipt >> foundDateCollection: anObject [

	foundDateCollection := anObject
]

{ #category : 'CheckDate' }
HfuEstimatedReceipt >> foundTimeCollection [

	^foundTimeCollection
]

{ #category : 'CheckDate' }
HfuEstimatedReceipt >> foundTimeCollection: anObject [

	foundTimeCollection := anObject
]

{ #category : 'API',
 #vaCategories : ['API','FilterAmounts'] }
HfuEstimatedReceipt >> grossAmount [
		
		"Gibt den Finalen Brutto Betrag zurueck"
		
	^grossAmount
]

{ #category : 'API',
 #vaCategories : ['API','FilterAmounts'] }
HfuEstimatedReceipt >> grossAmount: anObject [

	grossAmount := anObject
]

{ #category : 'FilterAmounts' }
HfuEstimatedReceipt >> grossAmountCollection [

		"Gibt mm den Brutto Betrag herraus zu finden "

	^grossAmountCollection
]

{ #category : 'FilterAmounts' }
HfuEstimatedReceipt >> grossAmountCollection: anObject [

	grossAmountCollection := anObject
]

{ #category : 'FilterAmounts' }
HfuEstimatedReceipt >> grossFromCalculateTax [

	^grossFromCalculateTax
]

{ #category : 'FilterAmounts' }
HfuEstimatedReceipt >> grossFromCalculateTax: anObject [

	grossFromCalculateTax := anObject
]

{ #category : 'API',
 #vaCategories : ['API','FilterAmounts'] }
HfuEstimatedReceipt >> grossWord [

	^grossWord
]

{ #category : 'API',
 #vaCategories : ['API','FilterAmounts'] }
HfuEstimatedReceipt >> grossWord: anObject [

	grossWord := anObject
]

{ #category : 'FilterAmounts' }
HfuEstimatedReceipt >> hasTwoTax [

	^hasTwoTax
]

{ #category : 'FilterAmounts' }
HfuEstimatedReceipt >> hasTwoTax: anObject [

	hasTwoTax := anObject
]

{ #category : 'CheckDate' }
HfuEstimatedReceipt >> isDate [

|aAllWordsCollection oneFoundDateCollection aTimescaleHelperVariable helperFoundDateCollection|
aAllWordsCollection := self allWordsCollection.
oneFoundDateCollection :=  SortedCollection new.
helperFoundDateCollection := SortedCollection new.


aAllWordsCollection := self allWordsCollection.
oneFoundDateCollection :=  SortedCollection new.
aAllWordsCollection do:[:eachWord| 
HfuEstimatedReceipt isDateSet do:[:eachDateFormat|(eachDateFormat match: eachWord)
ifTrue:[ 
oneFoundDateCollection add: ((eachWord asString) asTextractDate);
yourself.
].].].
self foundDateCollection: oneFoundDateCollection.
"-----------------------------------------------------"

(oneFoundDateCollection isEmpty)
ifFalse:[
date := (self foundDateCollection at:1).
].

"Transcript cr; show: (self date) asString, '#########--------------------##################--------------###########'."

aTimescaleHelperVariable := self foundDateCollection size.
((aTimescaleHelperVariable > 1) and:[self isHotelKeyWordSet])
ifTrue:[
beginDate := date.
endDate := (oneFoundDateCollection at: aTimescaleHelperVariable).
].

"
(oneFoundDateCollection isEmpty)
ifFalse:[
date := (self foundDateCollection at:1).
].

aTimescaleHelperVariable := self foundDateCollection size.
((aTimescaleHelperVariable > 1) and:[self isHotelKeyWordSet])
ifTrue:[
beginDate := date.
endDate := (oneFoundDateCollection at: aTimescaleHelperVariable).
]."

"asTextractDate"
"Sorted Collection"
"print Methode von Smalltalk"

"aAllWordsCollection do:[:eachWord| 
(eachWord isString)
ifTrue:[
aHelperVariable := eachWord.
(aHelperVariable asTextractDate) isNil
ifFalse:[
oneFoundDateCollection add: aHelperVariable;
yourself.
].].]."
"
oneFoundDateCollection do:[:eachWord | helperFoundDateCollection add: eachWord].

(oneFoundDateCollection isEmpty)
ifFalse:[
date := ((oneFoundDateCollection at:1) asString) asTextractDate.

dd := (((date asString) asTextractDate) asString asDateSubStrings) at:1.
mm := (((date asString) asTextractDate) asString asDateSubStrings) at:2.
yy := (((date asString) asTextractDate) asString asDateSubStrings) at:3.
date := (dd, '.' , mm, '.', yy).
].

aTimescaleHelperVariable := self foundDateCollection size.
((aTimescaleHelperVariable > 1) and:[self isHotelKeyWordSet])
ifTrue:[
beginDate := date."
"dd := (((beginDate asString) asTextractDate) asString asDateSubStrings) at:1.
mm := (((beginDate asString) asTextractDate) asString asDateSubStrings) at:2.
yy := (((beginDate asString) asTextractDate) asString asDateSubStrings) at:3.

endDate := ((oneFoundDateCollection at: aTimescaleHelperVariable) asString) asTextractDate.
dd := (((endDate asString) asTextractDate) asString asDateSubStrings) at:1.
mm := (((endDate asString) asTextractDate) asString asDateSubStrings) at:2.
yy := (((endDate asString) asTextractDate) asString asDateSubStrings) at:3.
endDate := (dd, '.' , mm, '.', yy).
].
"
"HfuEstimatedReceipt isDateSet do:[:eachDateFormat|(eachDateFormat match: eachWord)
ifTrue:[
oneFoundDateCollection add: eachWord;
yourself.
].].].
self foundDateCollection: oneFoundDateCollection."

"aAllWordsCollection do:[:eachWord| 
Receipt isWordDateSet do:[:eachDateFormat|(eachDateFormat includes: eachWord)
ifTrue:[
oneFoundDateCollection add: eachWord;
yourself.
].].].
self foundDateCollection: oneFoundDateCollection."
"
self foundDateCollection isEmpty
ifFalse:[
date := self foundDateCollection at:1.
((date asDate) isNil)
ifFalse:[
yearInRightFormat := (((date asDateSubStrings) at:3) asNumber \\ 100).
dd := (date asDateSubStrings) at:1.
mm := (date asDateSubStrings) at: 2.
yy := (yearInRightFormat asString).
date := (dd, '.' , mm, '.', yy).
].]."
]

{ #category : 'checkHotel' }
HfuEstimatedReceipt >> isHotelKeyWordSet [
|aAllWordsCollection|
aAllWordsCollection:= self allWordsCollection.

aAllWordsCollection do:[:eachWord| "Transcript show: 'Es ist ein Hotel'."
 HfuEstimatedReceipt isHotelSet do:[:eachHotel|(eachHotel match: eachWord)ifTrue: [^true.]."ifFalse: [Transcript show: 'Es ist kein Hotel']]"
].].

"Transcript show: 'Es ist kein Hotel'."
^false
]

{ #category : 'CheckDate' }
HfuEstimatedReceipt >> isTime [

|aAllWordsCollection oneFoundTimeCollection|
aAllWordsCollection := self allWordsCollection.
oneFoundTimeCollection :=  SortedCollection new.

aAllWordsCollection do:[:eachWord| 
HfuEstimatedReceipt isTimeSet do:[:eachTimeFormat|(eachTimeFormat match: eachWord)
ifTrue:[
oneFoundTimeCollection add: eachWord;
yourself.
].].].
self foundTimeCollection: oneFoundTimeCollection.
self foundTimeCollection select: [:eachTime |(self checkValidTime: eachTime).]. "or:[self checkValidTimeCaseTwo: eachTime])"

self foundTimeCollection isEmpty
ifFalse:[
atime := self foundTimeCollection at:1
].
]

{ #category : 'API',
 #vaCategories : ['API','ScanReceipt'] }
HfuEstimatedReceipt >> jsonPath [

	^jsonPath
]

{ #category : 'API',
 #vaCategories : ['API','ScanReceipt'] }
HfuEstimatedReceipt >> jsonPath: anObject [

	jsonPath := anObject
]

{ #category : 'FilterAmounts' }
HfuEstimatedReceipt >> keywordAmountCollection [


	^keywordAmountCollection
	
]

{ #category : 'FilterAmounts' }
HfuEstimatedReceipt >> keywordAmountCollection: anObject [

	keywordAmountCollection := anObject
]

{ #category : 'FilterAmounts' }
HfuEstimatedReceipt >> lastChance [

		(self grossAmount isNil)
		ifTrue: [ self grossAmount: '0.00'].
		(self netAmount isNil)
		ifTrue: [ self netAmount: '0.00'].
]

{ #category : 'FilterAmounts' }
HfuEstimatedReceipt >> mergeAmountCollections: aFirstAmountCollection secondCollection: aSecondAmountCollection keyword: aKeyword [

		| resultCollection secondResultCollection |
				
		resultCollection:= OrderedCollection new.
		secondResultCollection := OrderedCollection new.
		
		((aFirstAmountCollection isEmpty) and:[aSecondAmountCollection isEmpty])
		ifFalse: [ 
					((aFirstAmountCollection isEmpty))
					ifTrue:[ resultCollection addAll: (aSecondAmountCollection asOrderedCollection). 
								"resultCollection addAll: (self receiptAmountsCollection)"]
					ifFalse:[
					((aSecondAmountCollection isEmpty))
					ifTrue: [  resultCollection addAll:  (aFirstAmountCollection asOrderedCollection). 
									"resultCollection addAll: (self receiptAmountsCollection)"]
					ifFalse:[
			 (aFirstAmountCollection asOrderedCollection) do:[:eachAmount | 
			 ((aSecondAmountCollection asOrderedCollection) includes: eachAmount)  
			 ifTrue:[ resultCollection add: eachAmount]]]]]
			 
			 ifTrue:[resultCollection := (self receiptAmountsCollection)].
			 
			 "secondResultCollection addAll: (self filterHighestAmount: self receiptAmountsCollection).
			secondResultCollection do:[:eachAttribut | resultCollection add: eachAttribut].	"
				
			 ((aKeyword == 'gross')
			 ifTrue:[ self grossAmountCollection: OrderedCollection new.
						self grossAmountCollection addAll: resultCollection]).
			 
			 ((aKeyword == 'net')
			 ifTrue:[ self netAmountCollection: OrderedCollection new.
						self netAmountCollection addAll: resultCollection]).
			 
			  ((aKeyword == 'keyword')
			 ifTrue:[ self keywordAmountCollection: OrderedCollection new.
						self keywordAmountCollection removeAll.
						self keywordAmountCollection addAll: resultCollection]).
]

{ #category : 'FilterAmounts' }
HfuEstimatedReceipt >> mergeTaxAmountDictionary: aTaxAmountDicitonary [
		   
			| resultAmount resultSevenAmount resultNineteenAmount |
		   
			aTaxAmountDicitonary do:[:eachCollectionOfTupels |   | aAmount | aAmount := (eachCollectionOfTupels at: 1).
		   
			aTaxAmountDicitonary do:[:eachCollectionOfTupelsTwo | | aAmountTwo | (aAmountTwo := eachCollectionOfTupelsTwo at: 1).
			resultAmount := aAmountTwo + aAmount.
			
			((self checkIfAmountInCollection: resultAmount))
			ifTrue:[
			((eachCollectionOfTupels includes: 19)
			ifTrue:[ resultSevenAmount := (aTaxAmountDicitonary keyAtValue: eachCollectionOfTupels).
																							self mwstSeveWord: (resultSevenAmount/ 100) asFloat]
			ifFalse:[ resultNineteenAmount := aTaxAmountDicitonary keyAtValue: eachCollectionOfTupels.
																					self mwstNineteenWord: (resultNineteenAmount / 100) asFloat]).
			((eachCollectionOfTupelsTwo includes: 7)
			ifTrue:[ resultSevenAmount := aTaxAmountDicitonary keyAtValue: eachCollectionOfTupelsTwo.
																								self mwstSeveWord: (resultSevenAmount/ 100) asFloat]
			ifFalse:[ resultNineteenAmount := aTaxAmountDicitonary keyAtValue: eachCollectionOfTupelsTwo.
																							self mwstNineteenWord: (resultNineteenAmount / 100) asFloat])      
			]. 
			resultAmount := 0]].
]

{ #category : 'API',
 #vaCategories : ['API','FilterAmounts'] }
HfuEstimatedReceipt >> mwst [

	^mwst
]

{ #category : 'API',
 #vaCategories : ['API','FilterAmounts'] }
HfuEstimatedReceipt >> mwst: anObject [

	mwst := anObject
]

{ #category : 'API',
 #vaCategories : ['API','FilterAmounts'] }
HfuEstimatedReceipt >> mwstNineteenWord [

	^mwstNineteenWord
]

{ #category : 'API',
 #vaCategories : ['API','FilterAmounts'] }
HfuEstimatedReceipt >> mwstNineteenWord: anObject [

	mwstNineteenWord := anObject
]

{ #category : 'API',
 #vaCategories : ['API','FilterAmounts'] }
HfuEstimatedReceipt >> mwstSeveWord [

	^mwstSeveWord
]

{ #category : 'API',
 #vaCategories : ['API','FilterAmounts'] }
HfuEstimatedReceipt >> mwstSeveWord: anObject [

	mwstSeveWord := anObject
]

{ #category : 'API',
 #vaCategories : ['API','FilterAmounts'] }
HfuEstimatedReceipt >> mwstWord [

	^mwstWord
	
]

{ #category : 'API',
 #vaCategories : ['API','FilterAmounts'] }
HfuEstimatedReceipt >> mwstWord: anObject [

	mwstWord := anObject
]

{ #category : 'API',
 #vaCategories : ['API','ScanReceipt'] }
HfuEstimatedReceipt >> name [

	^name
]

{ #category : 'API',
 #vaCategories : ['API','ScanReceipt'] }
HfuEstimatedReceipt >> name: anObject [

	name := anObject
]

{ #category : 'API',
 #vaCategories : ['API','FilterAmounts'] }
HfuEstimatedReceipt >> netAmount [
		
		"Gibt den Finalen Netto Betrag zurueck"

	^ netAmount
]

{ #category : 'API',
 #vaCategories : ['API','FilterAmounts'] }
HfuEstimatedReceipt >> netAmount: anObject [

	netAmount := anObject
]

{ #category : 'FilterAmounts' }
HfuEstimatedReceipt >> netAmountCollection [
		
	"Gibt moegliche Netto Betrag Werte zurueck um den Netto Betrag herraus zu finden "
			
	^netAmountCollection
]

{ #category : 'FilterAmounts' }
HfuEstimatedReceipt >> netAmountCollection: anObject [

	netAmountCollection := anObject
]

{ #category : 'API',
 #vaCategories : ['API','FilterAmounts'] }
HfuEstimatedReceipt >> netWord [

	^netWord
	
]

{ #category : 'API',
 #vaCategories : ['API','FilterAmounts'] }
HfuEstimatedReceipt >> netWord: anObject [

	netWord := anObject
]

{ #category : 'API' }
HfuEstimatedReceipt >> path [

	^path
]

{ #category : 'API' }
HfuEstimatedReceipt >> path: anObject [

	path := anObject
]

{ #category : 'Positions' }
HfuEstimatedReceipt >> positions [

	^positions
]

{ #category : 'Positions' }
HfuEstimatedReceipt >> positions: anObject [

	positions := anObject
]

{ #category : 'FilterAmounts' }
HfuEstimatedReceipt >> receiptAmountsCollection [

	^receiptAmountsCollection
]

{ #category : 'FilterAmounts' }
HfuEstimatedReceipt >> receiptAmountsCollection: anObject [

	receiptAmountsCollection := anObject
]

{ #category : 'FilterAmounts' }
HfuEstimatedReceipt >> receiptAmountsCollectionInCent [

	^receiptAmountsCollectionInCent
]

{ #category : 'FilterAmounts' }
HfuEstimatedReceipt >> receiptAmountsCollectionInCent: aCollection [

	receiptAmountsCollectionInCent := aCollection.
]

{ #category : 'FilterAmounts' }
HfuEstimatedReceipt >> reduceAllWordsCollectionByKeyWord [
	
	| aKeyWordsDictionary aAllWordsCollection aAllWordsCollection2 aBoolean aString | 

	aKeyWordsDictionary := HfuEstimatedReceipt isAllKeyWordDictionary.
	
	aBoolean := true.
	aAllWordsCollection2:= OrderedCollection  new.
	aAllWordsCollection := OrderedCollection  new.
	aAllWordsCollection:= self allWordsCollection.
	
		self allWordsCollection doWithIndex:[
		:eachWord :index | 
		"Sind in allWords Keywords fuer Net + Gross + Mwst dabei dann setzte Instanzvariablen vom Beleg true"
		"Pruefe ob Keywords von Netto und Brutto 7 +19 Prozent vorhanden sind wenn beide enthalten sind dann setze hasTwo Words true
		 um in weiteren Methoden Wert fuer genauere Berechnung pruefen"
		(aKeyWordsDictionary includes: eachWord)
		ifTrue: [(aBoolean = true)
					ifTrue: [
					index to: aAllWordsCollection size do:[:eachWords |  
					aAllWordsCollection2 add: (aAllWordsCollection at: eachWords)].
					aBoolean := false.]    
					]].
	
	
	aAllWordsCollection := OrderedCollection  new.
	aAllWordsCollection2 do: [:eachAttribut | | eachWord | eachWord := (eachAttribut removeAllSpaces).
		
		(self checkIsAmountFormat: eachWord)
	ifTrue: [ aAllWordsCollection add: eachWord]].
	aAllWordsCollection doWithIndex: [:eachWord :index | (('*,' match: eachWord) or:['*.' match: (eachWord)]) 
								
	ifTrue: [     
				aString := (eachWord,'00').
				aAllWordsCollection replaceFrom: index to: index  withObject:  aString.
				]
	ifFalse:[((',##' match: eachWord) or:['.##' match: eachWord])
				ifTrue: [aString := ('0',eachWord).
				aAllWordsCollection replaceFrom: index to: index  withObject:  aString.]
				]].
	 
	 (aAllWordsCollection isNil)
	 ifTrue: [self grossAmount: 0.
				self netAmount: 0.
				self mwst: 0.
				self receiptAmountsCollection: nil.
				self fillReceiptAmountsCollectionInCent: nil] 
				ifFalse: [ (aAllWordsCollection isEmpty)
								ifTrue:[self allWordsCollection do: [:eachAttribut | | eachWord | eachWord := (eachAttribut removeAllSpaces).
								((self checkIsAmountFormat: eachWord) and:[eachWord ~= HfuEstimatedReceipt])
								ifTrue: [ aAllWordsCollection add: eachWord.
											 self removePointsFromNumber: aAllWordsCollection.]].
								self removePointsFromNumber: aAllWordsCollection.
								self receiptAmountsCollection: aAllWordsCollection.
								self fillReceiptAmountsCollectionInCent: aAllWordsCollection]
								ifFalse:[self removePointsFromNumber: aAllWordsCollection.
											self receiptAmountsCollection: aAllWordsCollection.
											self fillReceiptAmountsCollectionInCent: aAllWordsCollection]].

								
								
	
]

{ #category : 'FilterAmounts' }
HfuEstimatedReceipt >> removePointsFromNumber: aCollection [
				
				(aCollection asOrderedCollection) doWithIndex: [:eachAmount :index | (('*.*' match: eachAmount)) 
				ifTrue:[ eachAmount doWithIndex: [:eachChar :indexOfCharInString | (($.) == (eachChar))   
				ifTrue:[eachAmount replaceFrom: indexOfCharInString to: indexOfCharInString with:',' ]]]].
				^aCollection.
]

{ #category : 'FilterAmounts' }
HfuEstimatedReceipt >> removeWhitespaceOfCollectionAttributs: aCollection [

		aCollection do:[:eachAttribut | eachAttribut removeAllSpaces].
		
		^aCollection.
	
]

{ #category : 'ScanReceipt' }
HfuEstimatedReceipt >> scanReceipt: aReceiptNumber name: aName [


	self name: aName.
	self fillAllWordsCollection: aReceiptNumber.
	self fillAllTextractWordsCollection: aReceiptNumber.
	self fillAllTextractLinesCollection: aReceiptNumber.
	self fillDatas.
	self designateGrossAmount.
	self designateNetAmount.
	self lastChance.
	self designateMwstAmount.
	self isTime.
	self isDate.
	self amountOfPositions.
	"self isHotel."
	Transcript cr; show: aName asString, ' BELEG'.
	^self
]

{ #category : 'ScanReceipt' }
HfuEstimatedReceipt >> truncatePoint: aPointCollection [

				"schneidet denn Polygon Punkt ab der 2 stellen nach dem punkt ab - besser fuer den vergleich !!! "

				aPointCollection doWithIndex:[:eachPoint :index| eachPoint truncateTo: 0.01].
				
				^aPointCollection.


]
