var favorites = null;
var num = 1;
$("document")
		.ready(
				function() {

					var $table = $('#coinsTable');

					// execute the below code only where we have this table
					if ($table.length) {
						var favoritesUrl = window.contextRoot
								+ "/coins/get-fav";
						console.log(favoritesUrl);
						$
								.get(
										favoritesUrl,
										function(favorites) {
											var $table = $('#coinsTable');

											// execute the below code only where
											// we have this table
											if ($table.length) {
												// console.log('Inside the
												// table!');

												jsonUrl = 'https://api.coinmarketcap.com/v1/ticker/';

												$table
														.DataTable({
															lengthMenu : [
																	[ 10, 15,
																			20,
																			50,
																			-1 ],
																	[
																			'10 Records',
																			'15 Records',
																			'20 Records',
																			'50 Records',
																			'ALL' ] ],
															pageLength : 15,
															ajax : {
																url : jsonUrl,
																dataSrc : ''
															},
															columnDefs : [ {
																'max-width' : '20%',
																'targets' : 0
															} ],
															columns : [
																	{
																		data : 'rank',
																		bSortable : true
																	},
																	{
																		data : 'name',
																		mRender : function(
																				data,
																				type,
																				row) {
																			return '<span style="font-size:20px">'
																					+ data
																					+ '</span>';
																		}
																	},
																	{
																		data : 'symbol',
																		mRender : function(
																				data,
																				type,
																				row) {
																			return '<span style="font-weight:bold">'
																					+ data
																					+ '</span>';
																		}
																	},
																	{
																		data : 'price_usd',
																		mRender : function(
																				data,
																				type,
																				row) {
																			return '&#x24; '
																					+ data
																		}
																	},
																	{
																		data : 'percent_change_1h',
																		mRender : function(
																				data,
																				type,
																				row) {
																			if (data < 0)
																				return '<span style="color:red">'
																						+ data
																						+ '</span>';
																			else
																				return '<span style="color:green">'
																						+ data
																						+ '</span>';
																		}
																	},
																	{
																		data : 'percent_change_24h',
																		mRender : function(
																				data,
																				type,
																				row) {
																			if (data < 0)
																				return '<span style="color:red">'
																						+ data
																						+ '</span>';
																			else
																				return '<span style="color:green">'
																						+ data
																						+ '</span>';
																		},

																	},
																	{
																		data : 'id',
																		bSortable : false,
																		mRender : function(
																				data,
																				type,
																				row) {
																			var str = '';
																			var res = false;
																			for (var rr = 0; rr < favorites.length; rr++) {
																				if (favorites[rr] == data)
																					res = true;
																			}

																			if (res) {
																				str += '<label class="switch"> <input type="checkbox" value="'
																						+ data
																						+ '" checked="checked">  <div class="slider round"> </div></label>';

																			} else {
																				str += '<label class="switch"> <input type="checkbox" value="'
																						+ data
																						+ '">  <div class="slider round"> </div></label>';
																			}

																			return str;
																		}
																	} ],

															initComplete : function() {
																var api = this
																		.api();
																api
																		.$(
																				'.switch input[type="checkbox"]')
																		.on(
																				'change',
																				function() {
																					var dText = (this.checked) ? 'You want to set as Favorite?'
																							: 'You want to remove from favorites?';
																					var checked = this.checked;
																					var checkbox = $(this);
																					debugger;
																					bootbox
																							.confirm({
																								size : 'medium',
																								title : ' Set Favorite',
																								message : dText,
																								callback : function(
																										confirmed) {
																									if (confirmed) {
																										if (checked) {
																											$
																													.ajax({
																														type : 'GET',
																														url : window.contextRoot
																																+ '/coins/set-fav/'
																																+ checkbox
																																		.prop('value'),
																														timeout : 100000,
																														success : function(
																																data) {
																															bootbox
																																	.alert(data);
																														},
																														error : function(
																																e) {
																															bootbox
																																	.alert('ERROR');
																															// display(e);
																														}
																													});
																										} else {
																											$
																													.ajax({
																														type : 'GET',
																														url : window.contextRoot
																																+ '/coins/remove-fav/'
																																+ checkbox
																																		.prop('value'),
																														timeout : 100000,
																														success : function(
																																data) {
																															bootbox
																																	.alert(data);
																														},
																														error : function(
																																e) {
																															bootbox
																																	.alert('ERROR');
																															// display(e);
																														}
																													});
																										}
																									} else {
																										checkbox
																												.prop(
																														'checked',
																														!checked);
																									}
																								}
																							});
																				});

															}
														});
											}

										});

					}
					var $table2 = $('#fav-coins');

					// execute the below code only where we have this table
					if ($table2.length) {
					$
							.ajax({
								type : 'GET',
								url : window.contextRoot + '/coins/get-fav/',
								success : function(data) {

									if (data.length == 0)
										$('#fav-coin-content')
												.append(
														'<tr class="row100 body">'
																+ '<td class="cell100 column1" colspan="6" style="text-align:center">No Favorites Found</td></tr>');
									for (var i = 0; i < data.length; i++) {

										$
												.ajax({
													type : 'GET',
													url : 'https://api.coinmarketcap.com/v1/ticker/'
															+ data[i] + '/',
													success : function(data1) {

														var temp = '<tr class="row100 body">'
																+ '<td class="cell100 column1">'
																+ data1[0].rank
																+ '</td>'
																+ '<td class="cell100 column2">'
																+ data1[0].name
																+ '</td>'
																+ '<td class="cell100 column3" style="font-weight:bold">'
																+ data1[0].symbol
																+ '</td>'
																+ '<td class="cell100 column4">'
																+ data1[0].price_usd
																+ '</td>';
														if (data1[0].percent_change_1h < 0)
															temp = temp
																	+ '<td class="cell100 column5" style="color:red">'
																	+ data1[0].percent_change_1h
																	+ '</td>';
														else
															temp = temp
																	+ '<td class="cell100 column5" style="color:green">'
																	+ data1[0].percent_change_1h
																	+ '</td>';

														if (data1[0].percent_change_24h < 0)
															temp = temp
																	+ '<td class="cell100 column5" style="color:red">'
																	+ data1[0].percent_change_24h
																	+ '</td></tr>';
														else
															temp = temp
																	+ '<td class="cell100 column5" style="color:green">'
																	+ data1[0].percent_change_24h
																	+ '</td></tr>';
														$('#fav-coin-content')
																.append(temp);

													}

												});

									}

								},
								error : function(e) {

									// display(e);
								}
							});
					
					}

				});
